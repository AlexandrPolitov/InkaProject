function getRequest() {
    let url = 'https://api.github.com/repos/javascript-tutorial/en.javascript.info/commits';
    alert(url);
}

function loginClick() {
    location.href = 'http://localhost:8070/main';
}

function logoutClick() {
    location.href = 'http://localhost:8070/logout';
}

function get() {
    fetch('http://localhost:8070/getSmallUserInfo')
      .then(response => response.json())
      .then(commits => alert(commits.name));
}