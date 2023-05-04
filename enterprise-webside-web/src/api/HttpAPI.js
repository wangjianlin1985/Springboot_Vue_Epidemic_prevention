import request from '@/util/request'

export function savePatientL1(data) {
    return request({
        url: '/patient/savePatientL1',
        method: 'POST',
        data
    })
}

export function selectPatientL1(data) {
    return request({
        url: '/patient/selectPatientL1',
        method: 'POST',
        data
    })
}

export function updateById(data) {
    return request({
        url: '/patient/updateById',
        method: 'POST',
        data
    })
}

export function deleteById(data) {
    return request({
        url: '/patient/deleteById',
        method: 'GET',
        params: data
    })
}

export function saveCheckRecord(data) {
    return request({
        url: '/patient/saveCheckRecord',
        method: 'POST',
        data
    })
}

export function selectCheckRecordByPatentId(data) {
    return request({
        url: '/patient/selectCheckRecordByPatentId',
        method: 'POST',
        data
    })
}

export function savePatientL2(data) {
    return request({
        url: '/patient/savePatientL2',
        method: 'POST',
        data
    })
}

export function savePatientL3(data) {
    return request({
        url: '/patient/savePatientL3',
        method: 'POST',
        data
    })
}

export function savePatientL4(data) {
    return request({
        url: '/patient/savePatientL4',
        method: 'POST',
        data
    })
}

export function saveNews(data) {
    return request({
        url: '/patient/saveNews',
        method: 'POST',
        data
    })
}

export function selectPatientL2(data) {
    return request({
        url: '/patient/selectPatientL2',
        method: 'POST',
        data
    })
}

export function selectPatientL3(data) {
    return request({
        url: '/patient/selectPatientL3',
        method: 'POST',
        data
    })
}

export function selectPatientL4(data) {
    return request({
        url: '/patient/selectPatientL4',
        method: 'POST',
        data
    })
}

export function selectNews(data) {
    return request({
        url: '/patient/selectNews',
        method: 'POST',
        data
    })
}

export function updatePatientL2ById(data) {
    return request({
        url: '/patient/updatePatientL2ById',
        method: 'POST',
        data
    })
}

export function deletePatientL2ById(data) {
    return request({
        url: '/patient/deletePatientL2ById',
        method: 'GET',
        params: data
    })
}

export function updatePatientL3ById(data) {
    return request({
        url: '/patient/updatePatientL3ById',
        method: 'POST',
        data
    })
}

export function deletePatientL3ById(data) {
    return request({
        url: '/patient/deletePatientL3ById',
        method: 'GET',
        params: data
    })
}

export function updatePatientL4ById(data) {
    return request({
        url: '/patient/updatePatientL4ById',
        method: 'POST',
        data
    })
}

export function deletePatientL4ById(data) {
    return request({
        url: '/patient/deletePatientL4ById',
        method: 'GET',
        params: data
    })
}

export function updateNewsById(data) {
    return request({
        url: '/patient/updateNewsById',
        method: 'POST',
        data
    })
}

export function deleteNewsById(data) {
    return request({
        url: '/patient/deleteNewsById',
        method: 'GET',
        params: data
    })
}

export function saveWatchL1(data) {
    return request({
        url: '/patient/saveWatchL1',
        method: 'POST',
        data
    })
}

export function selectByPatientId(data) {
    return request({
        url: '/patient/selectByPatientId',
        method: 'GET',
        params: data
    })
}

export function selectWatchL1ByPatientId(data) {
    return request({
        url: '/patient/selectWatchL1ByPatientId',
        method: 'GET',
        params: data
    })
}

export function updateWatchStatusByPatient(data) {
    return request({
        url: '/patient/updateWatchStatusByPatient',
        method: 'POST',
        data
    });
}

export function saveWatchL2(data) {
    return request({
        url: '/patient/saveWatchL2',
        method: 'POST',
        data
    });
}

export function selectWatchL2ByPatientId(data) {
    return request({
        url: '/patient/selectWatchL2ByPatientId',
        method: 'GET',
        params: data
    });
}

export function saveWatchL3(data) {
    return request({
        url: '/patient/saveWatchL3',
        method: 'POST',
        data
    });
}

export function selectWatchL3ByPatientId(data) {
    return request({
        url: '/patient/selectWatchL3ByPatientId',
        method: 'GET',
        params: data
    });
}

export function saveLeader(data) {
    return request({
        url: '/patient/saveLeader',
        method: 'POST',
        data
    })
}

export function updateLeaderById(data) {
    return request({
        url: '/patient/updateLeaderById',
        method: 'POST',
        data
    })
}

export function deleteLeaderById(data) {
    return request({
        url: '/patient/deleteLeaderById',
        method: 'GET',
        params: data
    })
}

export function selectLeader(data) {
    return request({
        url: '/patient/selectLeader',
        method: 'POST',
        data
    })
}

export function saveUser(data) {
    return request({
        url: '/user/saveUser',
        method: 'POST',
        data
    })
}

export function updateUserById(data) {
    return request({
        url: '/user/updateUserById',
        method: 'POST',
        data
    })
}

export function deleteUserById(data) {
    return request({
        url: '/user/deleteUserById',
        method: 'GET',
        params: data
    })
}

export function selectUser(data) {
    return request({
        url: '/user/selectUser',
        method: 'POST',
        data
    })
}

export function selectCountByFromCity() {
    return request({
        url: '/patient/selectCountByFromCity',
        method: 'POST',
    })
}

export function logon(data) {
    return request({
        url: '/user/logon',
        method: 'POST',
        data
    })
}

export function checkAccount(data) {
    return request({
        url: '/user/checkAccount',
        method: 'POST',
        data
    })
}

