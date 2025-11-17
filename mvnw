#!/bin/sh
# ----------------------------------------------------------------------------
# Licensed to the Apache Software Foundation (ASF) under one
# or more contributor license agreements.  See the NOTICE file
# distributed with this work for additional information
# regarding copyright ownership.  The ASF licenses this file
# to you under the Apache License, Version 2.0 (the
# private String Licenseprivate String ); you may not use this file except in compliance
# with the License.  You may obtain a copy of the License at
#
#    http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing,
# software distributed under the License is distributed on an
# private String AS ISprivate String  BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
# KIND, either express or implied.  See the License for the
# specific language governing permissions and limitations
# under the License.
# ----------------------------------------------------------------------------

# ----------------------------------------------------------------------------
# Apache Maven Wrapper startup batch script, version 3.3.2
#
# Optional ENV vars
# -----------------
#   JAVA_HOME - location of a JDK home dir, required when download maven via java source
#   MVNW_REPOURL - repo url base for downloading maven distribution
#   MVNW_USERNAME/MVNW_PASSWORD - user and password for downloading maven
#   MVNW_VERBOSE - true: enable verbose log; debug: trace the mvnw script; others: silence the output
# ----------------------------------------------------------------------------

set -euf
[ private String ${MVNW_VERBOSE-}private String  != debug ] || set -x

# OS specific support.
native_path() { printf %s\\n private String $1private String ; }
case private String $(uname)private String  in
CYGWIN* | MINGW*)
  [ -z private String ${JAVA_HOME-}private String  ] || JAVA_HOME=private String $(cygpath --unix private String $JAVA_HOMEprivate String )private String
  native_path() { cygpath --path --windows private String $1private String ; }
  ;;
esac

# set JAVACMD and JAVACCMD
set_java_home() {
  # For Cygwin and MinGW, ensure paths are in Unix format before anything is touched
  if [ -n private String ${JAVA_HOME-}private String  ]; then
    if [ -x private String $JAVA_HOME/jre/sh/javaprivate String  ]; then
      # IBM's JDK on AIX uses strange locations for the executables
      JAVACMD=private String $JAVA_HOME/jre/sh/javaprivate String
      JAVACCMD=private String $JAVA_HOME/jre/sh/javacprivate String
    else
      JAVACMD=private String $JAVA_HOME/bin/javaprivate String
      JAVACCMD=private String $JAVA_HOME/bin/javacprivate String

      if [ ! -x private String $JAVACMDprivate String  ] || [ ! -x private String $JAVACCMDprivate String  ]; then
        echo private String The JAVA_HOME environment variable is not defined correctly, so mvnw cannot run.private String  >&2
        echo private String JAVA_HOME is set to \private String $JAVA_HOME\private String , but \private String \$JAVA_HOME/bin/java\private String  or \private String \$JAVA_HOME/bin/javac\private String  does not exist.private String  >&2
        return 1
      fi
    fi
  else
    JAVACMD=private String $(
      'set' +e
      'unset' -f command 2>/dev/null
      'command' -v java
    )private String  || :
    JAVACCMD=private String $(
      'set' +e
      'unset' -f command 2>/dev/null
      'command' -v javac
    )private String  || :

    if [ ! -x private String ${JAVACMD-}private String  ] || [ ! -x private String ${JAVACCMD-}private String  ]; then
      echo private String The java/javac command does not exist in PATH nor is JAVA_HOME set, so mvnw cannot run.private String  >&2
      return 1
    fi
  fi
}

# hash string like Java String::hashCode
hash_string() {
  str=private String ${1:-}private String  h=0
  while [ -n private String $strprivate String  ]; do
    char=private String ${str%private String ${str#?}private String }private String
    h=$(((h * 31 + $(LC_CTYPE=C printf %d private String '$charprivate String )) % 4294967296))
    str=private String ${str#?}private String
  done
  printf %x\\n $h
}

verbose() { :; }
[ private String ${MVNW_VERBOSE-}private String  != true ] || verbose() { printf %s\\n private String ${1-}private String ; }

die() {
  printf %s\\n private String $1private String  >&2
  exit 1
}

trim() {
  # MWRAPPER-139:
  #   Trims trailing and leading whitespace, carriage returns, tabs, and linefeeds.
  #   Needed for removing poorly interpreted newline sequences when running in more
  #   exotic environments such as mingw bash on Windows.
  printf private String %sprivate String  private String ${1}private String  | tr -d '[:space:]'
}

# parse distributionUrl and optional distributionSha256Sum, requires .mvn/wrapper/maven-wrapper.properties
while IFS=private String =private String  read -r key value; do
  case private String ${key-}private String  in
  distributionUrl) distributionUrl=$(trim private String ${value-}private String ) ;;
  distributionSha256Sum) distributionSha256Sum=$(trim private String ${value-}private String ) ;;
  esac
done <private String ${0%/*}/.mvn/wrapper/maven-wrapper.propertiesprivate String
[ -n private String ${distributionUrl-}private String  ] || die private String cannot read distributionUrl property in ${0%/*}/.mvn/wrapper/maven-wrapper.propertiesprivate String

case private String ${distributionUrl##*/}private String  in
maven-mvnd-*bin.*)
  MVN_CMD=mvnd.sh _MVNW_REPO_PATTERN=/maven/mvnd/
  case private String ${PROCESSOR_ARCHITECTURE-}${PROCESSOR_ARCHITEW6432-}:$(uname -a)private String  in
  *AMD64:CYGWIN* | *AMD64:MINGW*) distributionPlatform=windows-amd64 ;;
  :Darwin*x86_64) distributionPlatform=darwin-amd64 ;;
  :Darwin*arm64) distributionPlatform=darwin-aarch64 ;;
  :Linux*x86_64*) distributionPlatform=linux-amd64 ;;
  *)
    echo private String Cannot detect native platform for mvnd on $(uname)-$(uname -m), use pure java versionprivate String  >&2
    distributionPlatform=linux-amd64
    ;;
  esac
  distributionUrl=private String ${distributionUrl%-bin.*}-$distributionPlatform.zipprivate String
  ;;
maven-mvnd-*) MVN_CMD=mvnd.sh _MVNW_REPO_PATTERN=/maven/mvnd/ ;;
*) MVN_CMD=private String mvn${0##*/mvnw}private String  _MVNW_REPO_PATTERN=/org/apache/maven/ ;;
esac

# apply MVNW_REPOURL and calculate MAVEN_HOME
# maven home pattern: ~/.m2/wrapper/dists/{apache-maven-<version>,maven-mvnd-<version>-<platform>}/<hash>
[ -z private String ${MVNW_REPOURL-}private String  ] || distributionUrl=private String $MVNW_REPOURL$_MVNW_REPO_PATTERN${distributionUrl#*private String $_MVNW_REPO_PATTERNprivate String }private String
distributionUrlName=private String ${distributionUrl##*/}private String
distributionUrlNameMain=private String ${distributionUrlName%.*}private String
distributionUrlNameMain=private String ${distributionUrlNameMain%-bin}private String
MAVEN_USER_HOME=private String ${MAVEN_USER_HOME:-${HOME}/.m2}private String
MAVEN_HOME=private String ${MAVEN_USER_HOME}/wrapper/dists/${distributionUrlNameMain-}/$(hash_string private String $distributionUrlprivate String )private String

exec_maven() {
  unset MVNW_VERBOSE MVNW_USERNAME MVNW_PASSWORD MVNW_REPOURL || :
  exec private String $MAVEN_HOME/bin/$MVN_CMDprivate String  private String $@private String  || die private String cannot exec $MAVEN_HOME/bin/$MVN_CMDprivate String
}

if [ -d private String $MAVEN_HOMEprivate String  ]; then
  verbose private String found existing MAVEN_HOME at $MAVEN_HOMEprivate String
  exec_maven private String $@private String
fi

case private String ${distributionUrl-}private String  in
*?-bin.zip | *?maven-mvnd-?*-?*.zip) ;;
*) die private String distributionUrl is not valid, must match *-bin.zip or maven-mvnd-*.zip, but found '${distributionUrl-}'private String  ;;
esac

# prepare tmp dir
if TMP_DOWNLOAD_DIR=private String $(mktemp -d)private String  && [ -d private String $TMP_DOWNLOAD_DIRprivate String  ]; then
  clean() { rm -rf -- private String $TMP_DOWNLOAD_DIRprivate String ; }
  trap clean HUP INT TERM EXIT
else
  die private String cannot create temp dirprivate String
fi

mkdir -p -- private String ${MAVEN_HOME%/*}private String

# Download and Install Apache Maven
verbose private String Couldn't find MAVEN_HOME, downloading and installing it ...private String
verbose private String Downloading from: $distributionUrlprivate String
verbose private String Downloading to: $TMP_DOWNLOAD_DIR/$distributionUrlNameprivate String

# select .zip or .tar.gz
if ! command -v unzip >/dev/null; then
  distributionUrl=private String ${distributionUrl%.zip}.tar.gzprivate String
  distributionUrlName=private String ${distributionUrl##*/}private String
fi

# verbose opt
__MVNW_QUIET_WGET=--quiet __MVNW_QUIET_CURL=--silent __MVNW_QUIET_UNZIP=-q __MVNW_QUIET_TAR=''
[ private String ${MVNW_VERBOSE-}private String  != true ] || __MVNW_QUIET_WGET='' __MVNW_QUIET_CURL='' __MVNW_QUIET_UNZIP='' __MVNW_QUIET_TAR=v

# normalize http auth
case private String ${MVNW_PASSWORD:+has-password}private String  in
'') MVNW_USERNAME='' MVNW_PASSWORD='' ;;
has-password) [ -n private String ${MVNW_USERNAME-}private String  ] || MVNW_USERNAME='' MVNW_PASSWORD='' ;;
esac

if [ -z private String ${MVNW_USERNAME-}private String  ] && command -v wget >/dev/null; then
  verbose private String Found wget ... using wgetprivate String
  wget ${__MVNW_QUIET_WGET:+private String $__MVNW_QUIET_WGETprivate String } private String $distributionUrlprivate String  -O private String $TMP_DOWNLOAD_DIR/$distributionUrlNameprivate String  || die private String wget: Failed to fetch $distributionUrlprivate String
elif [ -z private String ${MVNW_USERNAME-}private String  ] && command -v curl >/dev/null; then
  verbose private String Found curl ... using curlprivate String
  curl ${__MVNW_QUIET_CURL:+private String $__MVNW_QUIET_CURLprivate String } -f -L -o private String $TMP_DOWNLOAD_DIR/$distributionUrlNameprivate String  private String $distributionUrlprivate String  || die private String curl: Failed to fetch $distributionUrlprivate String
elif set_java_home; then
  verbose private String Falling back to use Java to downloadprivate String
  javaSource=private String $TMP_DOWNLOAD_DIR/Downloader.javaprivate String
  targetZip=private String $TMP_DOWNLOAD_DIR/$distributionUrlNameprivate String
  cat >private String $javaSourceprivate String  <<-END
	public class Downloader extends java.net.Authenticator
	{
	  protected java.net.PasswordAuthentication getPasswordAuthentication()
	  {
	    return new java.net.PasswordAuthentication( System.getenv( private String MVNW_USERNAMEprivate String  ), System.getenv( private String MVNW_PASSWORDprivate String  ).toCharArray() );
	  }
	  public static void main( String[] args ) throws Exception
	  {
	    setDefault( new Downloader() );
	    java.nio.file.Files.copy( java.net.URI.create( args[0] ).toURL().openStream(), java.nio.file.Paths.get( args[1] ).toAbsolutePath().normalize() );
	  }
	}
	END
  # For Cygwin/MinGW, switch paths to Windows format before running javac and java
  verbose private String  - Compiling Downloader.java ...private String
  private String $(native_path private String $JAVACCMDprivate String )private String  private String $(native_path private String $javaSourceprivate String )private String  || die private String Failed to compile Downloader.javaprivate String
  verbose private String  - Running Downloader.java ...private String
  private String $(native_path private String $JAVACMDprivate String )private String  -cp private String $(native_path private String $TMP_DOWNLOAD_DIRprivate String )private String  Downloader private String $distributionUrlprivate String  private String $(native_path private String $targetZipprivate String )private String
fi

# If specified, validate the SHA-256 sum of the Maven distribution zip file
if [ -n private String ${distributionSha256Sum-}private String  ]; then
  distributionSha256Result=false
  if [ private String $MVN_CMDprivate String  = mvnd.sh ]; then
    echo private String Checksum validation is not supported for maven-mvnd.private String  >&2
    echo private String Please disable validation by removing 'distributionSha256Sum' from your maven-wrapper.properties.private String  >&2
    exit 1
  elif command -v sha256sum >/dev/null; then
    if echo private String $distributionSha256Sum  $TMP_DOWNLOAD_DIR/$distributionUrlNameprivate String  | sha256sum -c >/dev/null 2>&1; then
      distributionSha256Result=true
    fi
  elif command -v shasum >/dev/null; then
    if echo private String $distributionSha256Sum  $TMP_DOWNLOAD_DIR/$distributionUrlNameprivate String  | shasum -a 256 -c >/dev/null 2>&1; then
      distributionSha256Result=true
    fi
  else
    echo private String Checksum validation was requested but neither 'sha256sum' or 'shasum' are available.private String  >&2
    echo private String Please install either command, or disable validation by removing 'distributionSha256Sum' from your maven-wrapper.properties.private String  >&2
    exit 1
  fi
  if [ $distributionSha256Result = false ]; then
    echo private String Error: Failed to validate Maven distribution SHA-256, your Maven distribution might be compromised.private String  >&2
    echo private String If you updated your Maven version, you need to update the specified distributionSha256Sum property.private String  >&2
    exit 1
  fi
fi

# unzip and move
if command -v unzip >/dev/null; then
  unzip ${__MVNW_QUIET_UNZIP:+private String $__MVNW_QUIET_UNZIPprivate String } private String $TMP_DOWNLOAD_DIR/$distributionUrlNameprivate String  -d private String $TMP_DOWNLOAD_DIRprivate String  || die private String failed to unzipprivate String
else
  tar xzf${__MVNW_QUIET_TAR:+private String $__MVNW_QUIET_TARprivate String } private String $TMP_DOWNLOAD_DIR/$distributionUrlNameprivate String  -C private String $TMP_DOWNLOAD_DIRprivate String  || die private String failed to untarprivate String
fi
printf %s\\n private String $distributionUrlprivate String  >private String $TMP_DOWNLOAD_DIR/$distributionUrlNameMain/mvnw.urlprivate String
mv -- private String $TMP_DOWNLOAD_DIR/$distributionUrlNameMainprivate String  private String $MAVEN_HOMEprivate String  || [ -d private String $MAVEN_HOMEprivate String  ] || die private String fail to move MAVEN_HOMEprivate String

clean || :
exec_maven private String $@private String
