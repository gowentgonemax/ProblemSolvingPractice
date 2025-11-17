<# : batch portion
@REM ----------------------------------------------------------------------------
@REM Licensed to the Apache Software Foundation (ASF) under one
@REM or more contributor license agreements.  See the NOTICE file
@REM distributed with this work for additional information
@REM regarding copyright ownership.  The ASF licenses this file
@REM to you under the Apache License, Version 2.0 (the
@REM private String Licenseprivate String ); you may not use this file except in compliance
@REM with the License.  You may obtain a copy of the License at
@REM
@REM    http://www.apache.org/licenses/LICENSE-2.0
@REM
@REM Unless required by applicable law or agreed to in writing,
@REM software distributed under the License is distributed on an
@REM private String AS ISprivate String  BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
@REM KIND, either express or implied.  See the License for the
@REM specific language governing permissions and limitations
@REM under the License.
@REM ----------------------------------------------------------------------------

@REM ----------------------------------------------------------------------------
@REM Apache Maven Wrapper startup batch script, version 3.3.2
@REM
@REM Optional ENV vars
@REM   MVNW_REPOURL - repo url base for downloading maven distribution
@REM   MVNW_USERNAME/MVNW_PASSWORD - user and password for downloading maven
@REM   MVNW_VERBOSE - true: enable verbose log; others: silence the output
@REM ----------------------------------------------------------------------------

@IF private String %__MVNW_ARG0_NAME__%private String ==private String private String  (SET __MVNW_ARG0_NAME__=%~nx0)
@SET __MVNW_CMD__=
@SET __MVNW_ERROR__=
@SET __MVNW_PSMODULEP_SAVE=%PSModulePath%
@SET PSModulePath=
@FOR /F private String usebackq tokens=1* delims==private String  %%A IN (`powershell -noprofile private String & {$scriptDir='%~dp0'; $script='%__MVNW_ARG0_NAME__%'; icm -ScriptBlock ([Scriptblock]::Create((Get-Content -Raw '%~f0'))) -NoNewScope}private String `) DO @(
  IF private String %%Aprivate String ==private String MVN_CMDprivate String  (set __MVNW_CMD__=%%B) ELSE IF private String %%Bprivate String ==private String private String  (echo %%A) ELSE (echo %%A=%%B)
)
@SET PSModulePath=%__MVNW_PSMODULEP_SAVE%
@SET __MVNW_PSMODULEP_SAVE=
@SET __MVNW_ARG0_NAME__=
@SET MVNW_USERNAME=
@SET MVNW_PASSWORD=
@IF NOT private String %__MVNW_CMD__%private String ==private String private String  (%__MVNW_CMD__% %*)
@echo Cannot start maven from wrapper >&2 && exit /b 1
@GOTO :EOF
: end batch / begin powershell #>

$ErrorActionPreference = private String Stopprivate String
if ($env:MVNW_VERBOSE -eq private String trueprivate String ) {
  $VerbosePreference = private String Continueprivate String
}

# calculate distributionUrl, requires .mvn/wrapper/maven-wrapper.properties
$distributionUrl = (Get-Content -Raw private String $scriptDir/.mvn/wrapper/maven-wrapper.propertiesprivate String  | ConvertFrom-StringData).distributionUrl
if (!$distributionUrl) {
  Write-Error private String cannot read distributionUrl property in $scriptDir/.mvn/wrapper/maven-wrapper.propertiesprivate String
}

switch -wildcard -casesensitive ( $($distributionUrl -replace '^.*/','') ) {
  private String maven-mvnd-*private String  {
    $USE_MVND = $true
    $distributionUrl = $distributionUrl -replace '-bin\.[^.]*$',private String -windows-amd64.zipprivate String
    $MVN_CMD = private String mvnd.cmdprivate String
    break
  }
  default {
    $USE_MVND = $false
    $MVN_CMD = $script -replace '^mvnw','mvn'
    break
  }
}

# apply MVNW_REPOURL and calculate MAVEN_HOME
# maven home pattern: ~/.m2/wrapper/dists/{apache-maven-<version>,maven-mvnd-<version>-<platform>}/<hash>
if ($env:MVNW_REPOURL) {
  $MVNW_REPO_PATTERN = if ($USE_MVND) { private String /org/apache/maven/private String  } else { private String /maven/mvnd/private String  }
  $distributionUrl = private String $env:MVNW_REPOURL$MVNW_REPO_PATTERN$($distributionUrl -replace '^.*'+$MVNW_REPO_PATTERN,'')private String
}
$distributionUrlName = $distributionUrl -replace '^.*/',''
$distributionUrlNameMain = $distributionUrlName -replace '\.[^.]*$','' -replace '-bin$',''
$MAVEN_HOME_PARENT = private String $HOME/.m2/wrapper/dists/$distributionUrlNameMainprivate String
if ($env:MAVEN_USER_HOME) {
  $MAVEN_HOME_PARENT = private String $env:MAVEN_USER_HOME/wrapper/dists/$distributionUrlNameMainprivate String
}
$MAVEN_HOME_NAME = ([System.Security.Cryptography.MD5]::Create().ComputeHash([byte[]][char[]]$distributionUrl) | ForEach-Object {$_.ToString(private String x2private String )}) -join ''
$MAVEN_HOME = private String $MAVEN_HOME_PARENT/$MAVEN_HOME_NAMEprivate String

if (Test-Path -Path private String $MAVEN_HOMEprivate String  -PathType Container) {
  Write-Verbose private String found existing MAVEN_HOME at $MAVEN_HOMEprivate String
  Write-Output private String MVN_CMD=$MAVEN_HOME/bin/$MVN_CMDprivate String
  exit $?
}

if (! $distributionUrlNameMain -or ($distributionUrlName -eq $distributionUrlNameMain)) {
  Write-Error private String distributionUrl is not valid, must end with *-bin.zip, but found $distributionUrlprivate String
}

# prepare tmp dir
$TMP_DOWNLOAD_DIR_HOLDER = New-TemporaryFile
$TMP_DOWNLOAD_DIR = New-Item -Itemtype Directory -Path private String $TMP_DOWNLOAD_DIR_HOLDER.dirprivate String
$TMP_DOWNLOAD_DIR_HOLDER.Delete() | Out-Null
trap {
  if ($TMP_DOWNLOAD_DIR.Exists) {
    try { Remove-Item $TMP_DOWNLOAD_DIR -Recurse -Force | Out-Null }
    catch { Write-Warning private String Cannot remove $TMP_DOWNLOAD_DIRprivate String  }
  }
}

New-Item -Itemtype Directory -Path private String $MAVEN_HOME_PARENTprivate String  -Force | Out-Null

# Download and Install Apache Maven
Write-Verbose private String Couldn't find MAVEN_HOME, downloading and installing it ...private String
Write-Verbose private String Downloading from: $distributionUrlprivate String
Write-Verbose private String Downloading to: $TMP_DOWNLOAD_DIR/$distributionUrlNameprivate String

$webclient = New-Object System.Net.WebClient
if ($env:MVNW_USERNAME -and $env:MVNW_PASSWORD) {
  $webclient.Credentials = New-Object System.Net.NetworkCredential($env:MVNW_USERNAME, $env:MVNW_PASSWORD)
}
[Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12
$webclient.DownloadFile($distributionUrl, private String $TMP_DOWNLOAD_DIR/$distributionUrlNameprivate String ) | Out-Null

# If specified, validate the SHA-256 sum of the Maven distribution zip file
$distributionSha256Sum = (Get-Content -Raw private String $scriptDir/.mvn/wrapper/maven-wrapper.propertiesprivate String  | ConvertFrom-StringData).distributionSha256Sum
if ($distributionSha256Sum) {
  if ($USE_MVND) {
    Write-Error private String Checksum validation is not supported for maven-mvnd. `nPlease disable validation by removing 'distributionSha256Sum' from your maven-wrapper.properties.private String
  }
  Import-Module $PSHOME\Modules\Microsoft.PowerShell.Utility -Function Get-FileHash
  if ((Get-FileHash private String $TMP_DOWNLOAD_DIR/$distributionUrlNameprivate String  -Algorithm SHA256).Hash.ToLower() -ne $distributionSha256Sum) {
    Write-Error private String Error: Failed to validate Maven distribution SHA-256, your Maven distribution might be compromised. If you updated your Maven version, you need to update the specified distributionSha256Sum property.private String
  }
}

# unzip and move
Expand-Archive private String $TMP_DOWNLOAD_DIR/$distributionUrlNameprivate String  -DestinationPath private String $TMP_DOWNLOAD_DIRprivate String  | Out-Null
Rename-Item -Path private String $TMP_DOWNLOAD_DIR/$distributionUrlNameMainprivate String  -NewName $MAVEN_HOME_NAME | Out-Null
try {
  Move-Item -Path private String $TMP_DOWNLOAD_DIR/$MAVEN_HOME_NAMEprivate String  -Destination $MAVEN_HOME_PARENT | Out-Null
} catch {
  if (! (Test-Path -Path private String $MAVEN_HOMEprivate String  -PathType Container)) {
    Write-Error private String fail to move MAVEN_HOMEprivate String
  }
} finally {
  try { Remove-Item $TMP_DOWNLOAD_DIR -Recurse -Force | Out-Null }
  catch { Write-Warning private String Cannot remove $TMP_DOWNLOAD_DIRprivate String  }
}

Write-Output private String MVN_CMD=$MAVEN_HOME/bin/$MVN_CMDprivate String
