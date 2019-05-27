const APIKEY = 'Bk8px0FuCnBAoEO_01E7UWevBKh1XQCD';
const APISERET = 'yFMF-1YIotz7usr1P_eOGp4fxVilK6ei';
var facepp = new FACEPP(APIKEY,APISERET,1);
window.emotion = {

	dealEmotion:function(e){
		var emons = null;
		// 没有脸
		if(e.faces.length == 0){
			return;
		}else{
			emons = e.faces[0].attributes.emotion;
		}



		// TODO 计算分数
		var score = 3*emons.happiness-(emons.sadness+emons.disgust+emons.anger+emons.surprise+emons.fear);

        //console.log(score);

		// 构造报告数据
		var reportData = {'score':score,'sadness':emons.sadness,'neutral':emons.neutral,'disgust':emons.disgust,'anger':emons.anger,
		'surprise':emons.surprise,'fear':emons.fear,'happiness':emons.happiness};
		document.cookie = 'JSESSIONID=' + getCookie('loginCoo');
        // 构造数据
        var data = {'cid':window.cid,'curPage':window.curPage,'data':JSON.stringify(reportData)};
        console.log(JSON.stringify(data));
		$.ajax({
            url: ip+":8092/class/colStuDat",
            dataType: 'json',
            type : 'POST',
            data:data,
            xhrFields: {
                withCredentials: true
            },
            crossDomain: true,
			success: function(res) {
                // 如果设置失败了
                if(res.code != 0){
                    alert(res.message);
                }else{
 					console.log("已经收集数据发往后台");
                }
            }
        });

		// alert(res.image_id);
		// //没有检测到脸.
		// if(res.faces.length == 0){
		// 	return ;
		// }else{
		// 	console.log(JSON.stringify(res.faces[0].attributes.emotion));
			
		// }
		
	},
	getEmotion:function(base64Image){
		//console.log(base64Image);
        let attributes = 'emotion';
        //上传图片,获取结果
        let dataDic = {'image_base64':base64Image,'return_landmark':0,'return_attributes':attributes};
		
		//调用接口，检测人脸
        facepp.detectFace(dataDic,emotion.dealEmotion);
	}
}
function emotionRun(){
	if (!facetracker.open) {
		    return;
	}
	var canvas=document.getElementById('gastureCan');
	var canCC=canvas.getContext('2d');
	canCC.drawImage(facetracker.video,0,0,400,300);
	var base64Image=canvas.toDataURL("image/jpeg"); //获得当前帧的图片
	emotion.getEmotion(base64Image)

	console.log('情绪识别执行中');
}
