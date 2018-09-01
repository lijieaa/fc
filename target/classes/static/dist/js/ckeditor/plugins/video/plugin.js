/**
 * Created by Administrator on 2018/6/11 0011.
 */
CKEDITOR.plugins.add( 'video', {
    icons: 'video',
    init: function( editor ) {
        editor.addCommand( 'video', new CKEDITOR.dialogCommand( 'videoDialog' ) );

        editor.ui.addButton( 'Video', {
            label: '视频',
            command: 'video',
            toolbar: 'insert'
        });

        CKEDITOR.dialog.add( 'videoDialog', this.path + 'dialogs/video.js' );
    }
});