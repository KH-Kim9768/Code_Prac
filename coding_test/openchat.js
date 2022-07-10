function solution(record) {
    let answer = [];

    const users = {};
    let log = [];

    record.forEach(element => {
        const [ action, uid, nickname ] = element.split(' ');

        if (nickname) {
            users[uid] = nickname;
        }
        
        if (action !== 'Change') {
            log.push({
                uid: uid,
                action: action,
            });
        }
    });
    
    log.forEach(element => {
        let message = "";
        switch (element.action) {
            case 'Enter':
                message=`${users[element.uid]}님이 들어왔습니다.`
                break;

            case 'Leave':
                message=`${users[element.uid]}님이 나갔습니다.`
                break;
        }

        if (message.length > 0) {
            answer.push(message);
        }
        
    });
    return answer;
}

console.log(solution(["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]));