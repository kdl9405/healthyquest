var avatar = {
    init : function () {
        var _this = this;

        $('#btn-update').on('click', function () {
            _this.update();
        });

          },

    update : function () {
        var data = {
            temp : $('#avatar').val()
        };

        var id = $('#id').val();
        var avatar = $('#avatar').val();

        $.ajax({
            type: 'PUT',
            url : '/user/avatar/'+avatar,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('캐릭터가 생성되었습니다..');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

avatar.init();
