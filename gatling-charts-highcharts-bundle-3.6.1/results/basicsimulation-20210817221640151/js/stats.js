var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "2000",
        "ok": "1567",
        "ko": "433"
    },
    "minResponseTime": {
        "total": "3",
        "ok": "3",
        "ko": "12"
    },
    "maxResponseTime": {
        "total": "1784",
        "ok": "1361",
        "ko": "1784"
    },
    "meanResponseTime": {
        "total": "478",
        "ok": "247",
        "ko": "1317"
    },
    "standardDeviation": {
        "total": "592",
        "ok": "284",
        "ko": "653"
    },
    "percentiles1": {
        "total": "190",
        "ok": "154",
        "ko": "1690"
    },
    "percentiles2": {
        "total": "465",
        "ok": "308",
        "ko": "1720"
    },
    "percentiles3": {
        "total": "1722",
        "ok": "1128",
        "ko": "1750"
    },
    "percentiles4": {
        "total": "1751",
        "ok": "1332",
        "ko": "1767"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 1477,
    "percentage": 74
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 17,
    "percentage": 1
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 73,
    "percentage": 4
},
    "group4": {
    "name": "failed",
    "count": 433,
    "percentage": 22
},
    "meanNumberOfRequestsPerSecond": {
        "total": "1000",
        "ok": "783.5",
        "ko": "216.5"
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
        "total": "1000",
        "ok": "582",
        "ko": "418"
    },
    "minResponseTime": {
        "total": "118",
        "ok": "118",
        "ko": "119"
    },
    "maxResponseTime": {
        "total": "1784",
        "ok": "1361",
        "ko": "1784"
    },
    "meanResponseTime": {
        "total": "824",
        "ok": "469",
        "ko": "1317"
    },
    "standardDeviation": {
        "total": "656",
        "ok": "358",
        "ko": "658"
    },
    "percentiles1": {
        "total": "451",
        "ok": "372",
        "ko": "1692"
    },
    "percentiles2": {
        "total": "1678",
        "ok": "491",
        "ko": "1721"
    },
    "percentiles3": {
        "total": "1737",
        "ok": "1323",
        "ko": "1751"
    },
    "percentiles4": {
        "total": "1764",
        "ok": "1343",
        "ko": "1767"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 492,
    "percentage": 49
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 17,
    "percentage": 2
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 73,
    "percentage": 7
},
    "group4": {
    "name": "failed",
    "count": 418,
    "percentage": 42
},
    "meanNumberOfRequestsPerSecond": {
        "total": "500",
        "ok": "291",
        "ko": "209"
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
        "total": "1000",
        "ok": "985",
        "ko": "15"
    },
    "minResponseTime": {
        "total": "3",
        "ok": "3",
        "ko": "12"
    },
    "maxResponseTime": {
        "total": "1533",
        "ok": "417",
        "ko": "1533"
    },
    "meanResponseTime": {
        "total": "133",
        "ok": "115",
        "ko": "1325"
    },
    "standardDeviation": {
        "total": "178",
        "ok": "78",
        "ko": "515"
    },
    "percentiles1": {
        "total": "100",
        "ok": "99",
        "ko": "1526"
    },
    "percentiles2": {
        "total": "156",
        "ok": "155",
        "ko": "1531"
    },
    "percentiles3": {
        "total": "300",
        "ok": "289",
        "ko": "1532"
    },
    "percentiles4": {
        "total": "1524",
        "ok": "354",
        "ko": "1533"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 985,
    "percentage": 99
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
    "count": 15,
    "percentage": 2
},
    "meanNumberOfRequestsPerSecond": {
        "total": "500",
        "ok": "492.5",
        "ko": "7.5"
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