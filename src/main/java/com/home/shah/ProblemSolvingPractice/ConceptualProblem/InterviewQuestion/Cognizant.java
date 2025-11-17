package com.home.shah.ProblemSolvingPractice.ConceptualProblem.InterviewQuestion;

import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class Cognizant {
    public static void main(String[] args) {
        System.out.println(getUniqueCharsinString(" hello" ));
    }
    /*
    given a string, create another string with unique chars from string one with same order
    aabbccdd -> abcd
    hello -> helo
     */

    public static String getUniqueCharsinString(String s){
        if(s == null || s.isEmpty()) return " " ;

        return s.chars()
                .mapToObj( c-> (char) c)
                .collect(Collectors.toCollection(LinkedHashSet::new))
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    //traceId, spanId, service_name, type(request/response), message, timestamp\

    /*
    traceId = 123
    select req.traceid, req.spanId, req.service_name, re.timestamp as req_time, res.timestamp as resp_time,
    TimeStampDiff(MilliSecond, req.timestmao, res.timestamp) as run_time_ms from audit req join audit res
    on req.traceId = res.traceId and req.pandId = res.spanId and req.type = 'request' and res.type = 'response'
     */
}
