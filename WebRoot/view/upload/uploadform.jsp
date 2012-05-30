<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
<title>SWFUpload Demos - SWFObject Demo</title>
<script type="text/javascript" src="http://localhost:8080/tribus/view/fileupload/swfupload.js"></script>
<script type="text/javascript" src="http://localhost:8080/tribus/view/fileupload/swfupload.swfobject.js"></script>
<script type="text/javascript" src="http://localhost:8080/tribus/view/fileupload/swfupload.queue.js"></script>
<script type="text/javascript" src="http://localhost:8080/tribus/view/fileupload/fileprogress.js"></script>
<script type="text/javascript" src="http://localhost:8080/tribus/view/fileupload/handlers.js"></script>
<script type="text/javascript">
var swfu;

SWFUpload.onload = function () {
	var settings = {
		flash_url : "http://localhost:8080/tribus/view/fileupload/swfupload.swf",
		upload_url: "uploadAction.action",
		post_params: {
			"PHPSESSID" : "NONE",
			"HELLO-WORLD" : "Here I Am",
			".what" : "OKAY"
		},
		file_post_name:"myfile",
		file_size_limit : "10 MB",
		file_types : "*.*",
		file_types_description : "All Files",
		file_upload_limit : 6,
		file_queue_limit : 0,
		custom_settings : {
			progressTarget : "fsUploadProgress",
			cancelButtonId : "btnCancel"
		},
		debug: false,

		// Button Settings
		button_image_url : "http://localhost:8080/tribus/view/upload/XPButtonUploadText_61x22.png",
		button_placeholder_id : "spanButtonPlaceholder",
		button_width: 61,
		button_height: 22,

		// The event handler functions are defined in handlers.js
		swfupload_loaded_handler : swfUploadLoaded,
		file_queued_handler : fileQueued,
		file_queue_error_handler : fileQueueError,
		file_dialog_complete_handler : fileDialogComplete,
		upload_start_handler : uploadStart,
		upload_progress_handler : uploadProgress,
		upload_error_handler : uploadError,
		upload_success_handler : uploadSuccess,
		upload_complete_handler : uploadComplete,
		queue_complete_handler : queueComplete,	// Queue plugin event
		
		// SWFObject settings
		minimum_flash_version : "9.0.28",
		swfupload_pre_load_handler : swfUploadPreLoad,
		swfupload_load_failed_handler : swfUploadLoadFailed
	};

	swfu = new SWFUpload(settings);
}

</script>
</head>
<body>
<div id="header">
	<h1 id="logo"><a href="../"></a></h1>
	<div id="version"></div>
</div>

<div id="content">
	<form id="form1" action="#" method="post" enctype="multipart/form-data">		
		<div id="divSWFUploadUI">
			<div class="fieldset  flash" id="fsUploadProgress">
			<span class="legend"></span>
			</div>
			<p id="divStatus"></p>
			<p>
				<span id="spanButtonPlaceholder"></span>
				<input id="btnCancel" type="button" value="Cancel All Uploads" disabled="disabled" style="margin-left: 2px; height: 22px; font-size: 8pt;" />
				<br />
			</p>
		</div>
		<noscript>
			<div style="background-color: #FFFF66; border-top: solid 4px #FF9966; border-bottom: solid 4px #FF9966; margin: 10px 25px; padding: 10px 15px;">
			</div>
		</noscript>
		<div id="divLoadingContent" class="content" style="background-color: #FFFF66; border-top: solid 4px #FF9966; border-bottom: solid 4px #FF9966; margin: 10px 25px; padding: 10px 15px; display: none;">			
		</div>
		<div id="divLongLoading" class="content" style="background-color: #FFFF66; border-top: solid 4px #FF9966; border-bottom: solid 4px #FF9966; margin: 10px 25px; padding: 10px 15px; display: none;">
			
		</div>
		<div id="divAlternateContent" class="content" style="background-color: #FFFF66; border-top: solid 4px #FF9966; border-bottom: solid 4px #FF9966; margin: 10px 25px; padding: 10px 15px; display: none;">
			
			<a href="http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash"></a> 
		</div>
	</form>
</div>
</body>
</html>
