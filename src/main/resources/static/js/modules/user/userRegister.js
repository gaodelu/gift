var vm = new Vue({
    el: '#app',
    data: {
        user: {
            username: '',
            password: '',
            passwordDec: '',
            email: '',
            sex: '',
            phoneNumber: '',
            nickName: ''
        },
        usernameErrorShow: false,
        usernameErrorMsg: "用户名必填"
    },
    created: function () {
        console.log("vue created successfully");
        var config = {
            vx: 4,
            vy: 4,
            height: 2,
            width: 2,
            count: 100,
            color: "121, 162, 185",
            stroke: "100, 200, 180",
            dist: 6000,
            e_dist: 20000,
            max_conn: 10
        }
        CanvasParticle(config);
    },
    methods: {
        checkUserName: function () {
            if (vm.user.username == null || vm.user.username == '') {
                console.log('username cannot be null');
            }
        },
        checkPwd: function () {
            if (vm.user.password == null || vm.user.password == '') {
                console.log('password cannot be null');
            }
            vm.user.password = Base64.encode(vm.user.passwordDec);
        },
        login: function () {
            vm.user.passwordDec = Base64.encode(vm.user.passwordDec);
            $.ajax({
                url: '/LoginController/login',
                method: 'post',
                async: false,
                contentType: 'application/json',
                data: JSON.stringify(vm.user),
                success: function (r) {
                    console.log(r)
                    if (r.retCode == '00000') {
                        window.location.href = '/views/main.html';
                    } else {
                        alert(r.retMsg);
                    }
                }
            })
        }
    }
})