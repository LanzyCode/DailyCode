axios.interceptors.request.use(
    config => {
        const token = window.sessionStorage.getItem("token");
        token && (config.headers.Authorization = token);
        return config;
    },
    error => {
        return Promise.error(error);
    }
)

axios.interceptors.response.use(
    response => {
        if (response.status === 200) {
            return Promise.resolve(response);
        } else {
            return Promise.reject(response);
        }
    },
    error => {
        if (error.response.status) {
            switch (error.response.status) {
                // 401: 未登录
                // 未登录则跳转登录页面，并携带当前页面的路径
                // 在登录成功后返回当前页面，这一步需要在登录页操作。
                case 401:
                    //alert("需要登录");
                    console.log(window.parent);
                    if(window.parent != null) {
                        window.parent.location.href="http://localhost:8080/login.html";
                    } else {
                        location.href="http://localhost:8080/login.html";
                    }
                    break;
                case 403:
                    vue.$alert('权限不足', '权限不足');
                    break;
                default:
                    vue.$alert('响应错误', '响应错误');
            }
            return Promise.reject(error.response);
        }
    }
);