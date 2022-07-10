function solution(id_list, report, k) {
    let answer = [];
    let reportState = {};

    const reports = [...new Set(report)];

    reports.forEach((value, index, array) => {
        const [id, report] = value.split(' ');
        if (reportState[report] === undefined) {
            reportState[report] = [];
        }
        reportState[report].push(id);
    });
    
    let totalList = [];
    Object.keys(reportState).forEach((value, index, array) => {
        if(reportState[value].length >= k) {
            totalList = [...totalList, ...reportState[value]];
        }
    })
    
    id_list.forEach((value, index, array) => {
        answer[index] = totalList.filter((el, index, array) => {
            return value === el; 
        }).length;
    });
    
    return answer;
}

solution(["muzi", "frodo", "apeach", "neo"], ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"], 2);
solution(["con", "ryan"], ["ryan con", "ryan con", "ryan con", "ryan con"], 2);


{
    store_code1: {
        product
    }
}
