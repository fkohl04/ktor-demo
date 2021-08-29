var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "2",
        "ok": "0",
        "ko": "2"
    },
    "minResponseTime": {
        "total": "2",
        "ok": "-",
        "ko": "2"
    },
    "maxResponseTime": {
        "total": "34",
        "ok": "-",
        "ko": "34"
    },
    "meanResponseTime": {
        "total": "18",
        "ok": "-",
        "ko": "18"
    },
    "standardDeviation": {
        "total": "16",
        "ok": "-",
        "ko": "16"
    },
    "percentiles1": {
        "total": "18",
        "ok": "-",
        "ko": "18"
    },
    "percentiles2": {
        "total": "26",
        "ok": "-",
        "ko": "26"
    },
    "percentiles3": {
        "total": "32",
        "ok": "-",
        "ko": "32"
    },
    "percentiles4": {
        "total": "34",
        "ok": "-",
        "ko": "34"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 2,
    "percentage": 100
},
    "meanNumberOfRequestsPerSecond": {
        "total": "2",
        "ok": "-",
        "ko": "2"
    }
},
contents: {
"req_request-1-46da4": {
        type: "REQUEST",
        name: "request_1",
path: "request_1",
pathFormatted: "req_request-1-46da4",
stats: {
    "name": "request_1",
    "numberOfRequests": {
        "total": "1",
        "ok": "0",
        "ko": "1"
    },
    "minResponseTime": {
        "total": "34",
        "ok": "-",
        "ko": "34"
    },
    "maxResponseTime": {
        "total": "34",
        "ok": "-",
        "ko": "34"
    },
    "meanResponseTime": {
        "total": "34",
        "ok": "-",
        "ko": "34"
    },
    "standardDeviation": {
        "total": "0",
        "ok": "-",
        "ko": "0"
    },
    "percentiles1": {
        "total": "34",
        "ok": "-",
        "ko": "34"
    },
    "percentiles2": {
        "total": "34",
        "ok": "-",
        "ko": "34"
    },
    "percentiles3": {
        "total": "34",
        "ok": "-",
        "ko": "34"
    },
    "percentiles4": {
        "total": "34",
        "ok": "-",
        "ko": "34"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 1,
    "percentage": 100
},
    "meanNumberOfRequestsPerSecond": {
        "total": "1",
        "ok": "-",
        "ko": "1"
    }
}
    },"req_request-2-93baf": {
        type: "REQUEST",
        name: "request_2",
path: "request_2",
pathFormatted: "req_request-2-93baf",
stats: {
    "name": "request_2",
    "numberOfRequests": {
        "total": "1",
        "ok": "0",
        "ko": "1"
    },
    "minResponseTime": {
        "total": "2",
        "ok": "-",
        "ko": "2"
    },
    "maxResponseTime": {
        "total": "2",
        "ok": "-",
        "ko": "2"
    },
    "meanResponseTime": {
        "total": "2",
        "ok": "-",
        "ko": "2"
    },
    "standardDeviation": {
        "total": "0",
        "ok": "-",
        "ko": "0"
    },
    "percentiles1": {
        "total": "2",
        "ok": "-",
        "ko": "2"
    },
    "percentiles2": {
        "total": "2",
        "ok": "-",
        "ko": "2"
    },
    "percentiles3": {
        "total": "2",
        "ok": "-",
        "ko": "2"
    },
    "percentiles4": {
        "total": "2",
        "ok": "-",
        "ko": "2"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 1,
    "percentage": 100
},
    "meanNumberOfRequestsPerSecond": {
        "total": "1",
        "ok": "-",
        "ko": "1"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
