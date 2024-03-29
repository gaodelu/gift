var vm = new Vue({
    el: '#app',
    data: {
        user: {
            username: '',
            password: '',
            passwordDec: ''
        },
        usernameErrorShow: false,
        usernameErrorMsg: "用户名不能为空",
        passwordErrorShow: false,
        passwordErrorMsg: "密码不能为空"
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
            vm.usernameErrorShow = false;
            if (vm.user.username == null || vm.user.username == '') {
                vm.usernameErrorShow = true;
                vm.usernameErrorMsg = "用户名不能为空";
                return false;
            }
            return true;
        },
        checkPwd: function () {
            vm.passwordErrorShow = false;
            if (vm.user.passwordDec == null || vm.user.passwordDec == '') {
                vm.passwordErrorShow = true;
                vm.passwordErrorMsg = "密码不能为空"
                return false;
            }
            vm.user.password = Base64.encode(vm.user.passwordDec);
            return true;
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
                    if (r.head.retCode == '00000') {
                        window.location.href = '/views/main.html';
                        alert(r.body.loginId)
                    } else {
                        alert(r.head.retMsg);
                    }
                }
            })
        },
        register: function () {

        }
    }
})