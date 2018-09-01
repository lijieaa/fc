/**
 * Created by Administrator on 2018/6/11 0011.
 */
CKEDITOR.dialog.add( 'videoDialog', function ( editor ) {
    return {
        title: '视频属性',
        minWidth: 400,
        minHeight: 200,

        contents: [
            {
                id: 'flv',
                label: 'VIDEO URL',
                elements: [
                    {
                        type: 'text',
                        id: 'flvLink',
                        label: '输入视频路径',
                        validate: CKEDITOR.dialog.validate.notEmpty( "视频路径不能为空！" )
                    }
                ]
            }
        ],

        onOk: function() {
            var dialog = this;
            var video = editor.document.createElement( 'video' );
            video.setAttribute('src', dialog.getValueOf('flv', 'flvLink'));
            editor.insertElement( video );
        }
    };
});