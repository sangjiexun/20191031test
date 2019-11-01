/*
 * submit を行います。
 * onclick などのイベントハンドラに記述します。
 * 戻るボタンなどの実装に利用することを想定しています。
 *
 * @param url 送信先URL
 */
function _submit(url) {
    var thisForm = document.forms[0];
    thisForm.action = url;
    thisForm.submit();
}

/**
 * submit ボタンを無効にします。
 * form 要素のイベントハンドラ onsubmit に記述します。
 *
 * @param form html-form要素
 */
function disableSubmit(form) {
    var elements = form.elements;
    for (var i = 0; i < elements.length; i++) {
        if (elements[i].type == 'submit' && elements[i].name.indexOf('CANCEL') == -1) {
            elements[i].disabled = true;
        }
    }
}

/**
 * イベントリスナーを追加する関数です。
 * クロスブラウザ対応版。
 *
 * @param event 追加するイベント
 * @param obj 追加する対象
 * @param func 実行する関数
 */
function addEvent(event, obj, func) {
    if(obj.addEventListener) {
        obj.addEventListener(event, func, false);  // non-IE
    } else {
        obj.attachEvent('on' + event, func); // IE
    }
}

/**
 * 画像のサイズを取得します。
 *
 * @param id 画像のID
 * @return map 画像のサイズ
 * @author 2009/03/03 Lee hosup追加
 */
function getImageSize(obj){
    var w = obj.offsetWidth;
    var h = obj.offsetHeight;
    return {width:w,height:h};
}

/**
 * 数値を指定された桁数に合わせての四捨五入。
 *
 * @param val 数値
 * @param pos 四捨五入する桁数
 * @return 四捨五入された数値
 * @author 2009/03/03 Lee hosup追加
 */
function exRound(val, pos)
{
    var rtn;
    rtn = Math.round(val * Math.pow(10, Math.abs(pos)-1))
    rtn = rtn / Math.pow(10, Math.abs(pos)-1)


    return rtn;
}

/**
 * 現在オブジェクトの状態に合わせて、ターゲットオブジェクトを活性化/非活性化します。
 *
 * 出稿情報関連画面でアピールアイコンとリスティングチェックボックスで使われる。
 *
 * @param val 現在選択オブジェクト
 * @param targetId ターゲット
 * @author 2009/03/03 Lee hosup追加
 */
function controlCheckbox(obj, targetId) {
  target = document.getElementById(targetId);
    if (obj.checked) {
      target.disabled = false;
    } else {
      target.disabled = true;
    }
}

/**
 * 画像情報を取得し、指定カラムに情報を書き込む。
 *
 * 出稿情報関連画面でアピールアイコンとリスティングチェックボックスで使われる。
 *
 * @param imgId 画像情報を取得するオブジェクトのID
 * @param picSizeId 画像サイズの書き込むオブジェクトID
 * @param fileSizeId ファイルサイズを書き込むオブジェクトID
 * @param rateId 画像の横×縦比率を書き込むオブジェクトID
 *
 * @author 2009/03/03 Lee hosup追加
 */
function setImageInfo(imgId, picSizeId, fileSizeId, rateId) {
    var obj = document.getElementById(imgId);
    if (obj == null) return;

    var picSize = getImageSize(obj);
    document.getElementById(picSizeId).innerText = picSize.width + 'px × ' + picSize.height + 'px';
    document.getElementById(fileSizeId).innerText = exRound(obj.fileSize/1024,3) + 'KB';
    document.getElementById(rateId).innerText = 1 + ':' + exRound((picSize.height / picSize.width),3);
}

/**
 * Text,TextAreaの入力文字数を表示します。
 *
 * @param field 入力文字数をチェックする対象オブジェクトID
 * @param counter 入力文字数を書き込むオブジェクトID
 * @param maxlimit 最大入力文字数
 *
 * @author 2009/03/03 Lee hosup追加
 */
function textCounter(field,counter,maxlimit) {

	var fieldWidth =  parseInt(field.offsetWidth);
	var fieldValue = field.value.replace(/\r\n/gi,'あ');

	var charcnt = fieldValue.length;
	if (charcnt > maxlimit) {
		document.getElementById(counter).style.color = "red";
	} else {
		document.getElementById(counter).style.color = "black";
	}
	document.getElementById(counter).innerHTML= '入力文字数：' + charcnt + " / " + maxlimit;
}
/******************************* crnwl ****************/
$(function(){
	//$('textarea').maxlength({});
	$('textarea[maxlength][data-displength=true],input[maxlength][data-displength=true]').each(function(){
		var e = $(this);
		//var t = '入力文字数：' + e.prop('textLength') + " / " + e.attr('maxlength');
		var t = '入力文字数：' + e.val().replace(/\r\n/gi,'あ').length + " / " + e.attr('maxlength');
		var div = $('<div></div>').width(e.width()).css('text-align','right').text(t);
		e.before(div);
		e.on('click blur keydown keyup keypress change',div,function(){
			div.text('入力文字数：' + e.val().replace(/\r\n/gi,'あ').length + " / " + e.attr('maxlength'));
		});
		e.on('DOMAttrModified mouseup',function(){
			div.width(e.width());
		});
	});

	// 数値
	$(".numeric").numeric();
	// 整数
	$(".integer").numeric({ decimal: false });
	// 正の数値
	$(".positive").numeric({ negative: false });
	// 正の整数
	$(".positive-integer").numeric({ decimal: false, negative: false });

	// *「右クリック貼り付け」対応
	$(".antirc").change(function() {
	    $(this).keyup();
	});
});

