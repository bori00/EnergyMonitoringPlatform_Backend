import {HOST} from "../hosts";
import RestApiClient from "../api/rest-client";

const endpoint = {
    login: '/auth/login'
};

const util = require('util')

const USER_KEY = 'user';

 function login(callback, username, password) {

    const body = {"userName": username, "password": password}

    const request = new Request(HOST.backend_api + endpoint.login, {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(body)
    });

    console.log(request.url);
    RestApiClient.performRequest(request, callback);
}

function setActiveUser(user) {
    localStorage.setItem(USER_KEY, JSON.stringify(user));
}

function logout() {
    localStorage.removeItem(USER_KEY);
}

// async register(username, password, emailAddress, isTeacher, nativeLanguage) {
//
//     const body = {"name": username,
//         "password": password,
//         "emailAddress": emailAddress,
//         "userType": isTeacher ? "TEACHER" : "STUDENT",
//         "nativeLanguage": nativeLanguage};
//
//     return fetch(API_URL + "register", {
//         method: 'POST',
//         headers: {
//             Accept: 'application/json',
//             'Content-Type': 'application/json',
//             "charset": "UTF-8"
//         },
//         body: JSON.stringify(body)
//     })
// }

function getCurrentUser() {
    return  JSON.parse(localStorage.getItem(USER_KEY))
}

function getCurrentUserRole() {
     if (localStorage.getItem(USER_KEY) !== null) {
         return  JSON.parse(localStorage.getItem('user')).role;
     }
     return null;
}

// guaranteeUserHasRole(role, component) {
//     const user = this.getCurrentUser();
//     if (user.role !== role) {
//         this.logout();
//         component.props.history.push("/login");
//         window.location.reload();
//         window.alert("Please sign in with a " + role + " account to access this" +
//             " functionality.");
//     }
// }

export {
    login,
    setActiveUser,
    logout,
    getCurrentUser,
    getCurrentUserRole
};