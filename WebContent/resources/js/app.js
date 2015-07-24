$(document).ready(function() {
	// auto-refresh task
	updateMessageNotifications();
	setInterval('updateMessageNotifications()', 5000);

});

$(document).on('click', '.icon_minim', function(e) {
	var $this = $(this);
	if (!$this.hasClass('panel-collapsed')) {
		$this.parents('.panel').find('.panel-body').slideUp();
		$this.addClass('panel-collapsed');
		$this.removeClass('glyphicon-minus').addClass('glyphicon-plus');
	} else {
		$this.parents('.panel').find('.panel-body').slideDown();
		$this.removeClass('panel-collapsed');
		$this.removeClass('glyphicon-plus').addClass('glyphicon-minus');
	}
});

function updateMessageNotifications() {
	$.ajax({
		type : 'GET',
		url : 'updateMessageNotifications',
		success : function(response) {
			/*
			 * $('#chatBody').html(''); $('#chatBody').append(response)
			 */
			$('#msgNotification').html('');
			$('#msgNotification').append(response);
		},
	});
}

$(document).on('click', '.icon_close', function(e) {
	$(this).parent().parent().parent().remove();

});

function downloadFile(elem) {
	var messageID = $(elem).attr("id");
	alert(messageID);
}

function sendMessage(elem) {
	var text = $('#chatMessage').val();
	var friendID = $(elem).attr("id");
	var length = $.trim(text).length;
	if (length < 200 && length != 0) {
		postChatMessage(text, friendID);
	} else {
		$('#chatMessage').val('');
		alert('message cannot be empty');
		/*
		 * $('span#flash').attr("class", "error"); $('span#flash').html('The
		 * message is empty'); $('span#flash').fadeIn(2000)
		 * $('span#flash').delay(5000).fadeOut(2000);
		 */
	}
}

function postChatMessage(message, friendID) {
	 var definition = {smile:{title:"Smile",codes:[":)",":=)",":-)"]},"sad-smile":{title:"Sad Smile",codes:[":(",":=(",":-("]},"big-smile":{title:"Big Smile",codes:[":D",":=D",":-D",":d",":=d",":-d"]},cool:{title:"Cool",codes:["8)","8=)","8-)","B)","B=)","B-)","(cool)"]},wink:{title:"Wink",codes:[":o",":=o",":-o",":O",":=O",":-O"]},crying:{title:"Crying",codes:[";(",";-(",";=("]},sweating:{title:"Sweating",codes:["(sweat)","(:|"]},speechless:{title:"Speechless",codes:[":|",":=|",":-|"]},kiss:{title:"Kiss",codes:[":*",":=*",":-*"]},"tongue-out":{title:"Tongue Out",codes:[":P",":=P",":-P",":p",":=p",":-p"]},blush:{title:"Blush",codes:["(blush)",":$",":-$",":=$",':">']},wondering:{title:"Wondering",codes:[":^)"]},sleepy:{title:"Sleepy",codes:["|-)","I-)","I=)","(snooze)"]},dull:{title:"Dull",codes:["|(","|-(","|=("]},"in-love":{title:"In love",codes:["(inlove)"]},"evil-grin":{title:"Evil grin",codes:["]:)",">:)","(grin)"]},talking:{title:"Talking",codes:["(talk)"]},yawn:{title:"Yawn",codes:["(yawn)","|-()"]},puke:{title:"Puke",codes:["(puke)",":&",":-&",":=&"]},"doh!":{title:"Doh!",codes:["(doh)"]},angry:{title:"Angry",codes:[":@",":-@",":=@","x(","x-(","x=(","X(","X-(","X=("]},"it-wasnt-me":{title:"It wasn't me",codes:["(wasntme)"]},party:{title:"Party!!!",codes:["(party)"]},worried:{title:"Worried",codes:[":S",":-S",":=S",":s",":-s",":=s"]},mmm:{title:"Mmm...",codes:["(mm)"]},nerd:{title:"Nerd",codes:["8-|","B-|","8|","B|","8=|","B=|","(nerd)"]},"lips-sealed":{title:"Lips Sealed",codes:[":x",":-x",":X",":-X",":#",":-#",":=x",":=X",":=#"]},hi:{title:"Hi",codes:["(hi)"]},call:{title:"Call",codes:["(call)"]},devil:{title:"Devil",codes:["(devil)"]},angel:{title:"Angel",codes:["(angel)"]},envy:{title:"Envy",codes:["(envy)"]},wait:{title:"Wait",codes:["(wait)"]},bear:{title:"Bear",codes:["(bear)","(hug)"]},"make-up":{title:"Make-up",codes:["(makeup)","(kate)"]},"covered-laugh":{title:"Covered Laugh",codes:["(giggle)","(chuckle)"]},"clapping-hands":{title:"Clapping Hands",codes:["(clap)"]},thinking:{title:"Thinking",codes:["(think)",":?",":-?",":=?"]},bow:{title:"Bow",codes:["(bow)"]},rofl:{title:"Rolling on the floor laughing",codes:["(rofl)"]},whew:{title:"Whew",codes:["(whew)"]},happy:{title:"Happy",codes:["(happy)"]},smirking:{title:"Smirking",codes:["(smirk)"]},nodding:{title:"Nodding",codes:["(nod)"]},shaking:{title:"Shaking",codes:["(shake)"]},punch:{title:"Punch",codes:["(punch)"]},emo:{title:"Emo",codes:["(emo)"]},yes:{title:"Yes",codes:["(y)","(Y)","(ok)"]},no:{title:"No",codes:["(n)","(N)"]},handshake:{title:"Shaking Hands",codes:["(handshake)"]},skype:{title:"Skype",codes:["(skype)","(ss)"]},heart:{title:"Heart",codes:["(h)","<3","(H)","(l)","(L)"]},"broken-heart":{title:"Broken heart",codes:["(u)","(U)"]},mail:{title:"Mail",codes:["(e)","(m)"]},flower:{title:"Flower",codes:["(f)","(F)"]},rain:{title:"Rain",codes:["(rain)","(london)","(st)"]},sun:{title:"Sun",codes:["(sun)"]},time:{title:"Time",codes:["(o)","(O)","(time)"]},music:{title:"Music",codes:["(music)"]},movie:{title:"Movie",codes:["(~)","(film)","(movie)"]},phone:{title:"Phone",codes:["(mp)","(ph)"]},coffee:{title:"Coffee",codes:["(coffee)"]},pizza:{title:"Pizza",codes:["(pizza)","(pi)"]},cash:{title:"Cash",codes:["(cash)","(mo)","($)"]},muscle:{title:"Muscle",codes:["(muscle)","(flex)"]},cake:{title:"Cake",codes:["(^)","(cake)"]},beer:{title:"Beer",codes:["(beer)"]},drink:{title:"Drink",codes:["(d)","(D)"]},dance:{title:"Dance",codes:["(dance)","\\o/","\\:D/","\\:d/"]},ninja:{title:"Ninja",codes:["(ninja)"]},star:{title:"Star",codes:["(*)"]},mooning:{title:"Mooning",codes:["(mooning)"]},finger:{title:"Finger",codes:["(finger)"]},bandit:{title:"Bandit",codes:["(bandit)"]},drunk:{title:"Drunk",codes:["(drunk)"]},smoking:{title:"Smoking",codes:["(smoking)","(smoke)","(ci)"]},toivo:{title:"Toivo",codes:["(toivo)"]},rock:{title:"Rock",codes:["(rock)"]},headbang:{title:"Headbang",codes:["(headbang)","(banghead)"]},bug:{title:"Bug",codes:["(bug)"]},fubar:{title:"Fubar",codes:["(fubar)"]},poolparty:{title:"Poolparty",codes:["(poolparty)"]},swearing:{title:"Swearing",codes:["(swear)"]},tmi:{title:"TMI",codes:["(tmi)"]},heidy:{title:"Heidy",codes:["(heidy)"]},myspace:{title:"MySpace",codes:["(MySpace)"]},malthe:{title:"Malthe",codes:["(malthe)"]},tauri:{title:"Tauri",codes:["(tauri)"]},priidu:{title:"Priidu",codes:["(priidu)"]}};
	$.emoticons.define(definition);
	newMessage = $.emoticons.replace(message);
	
	$.ajax({
		type : 'POST',
		url : 'postMessage',
		/* dataType : 'json', */
		data : {
			text : newMessage,
			friendID : friendID
		},
		success : function(response) {
			$('#chatMessage').val('');
			$("#messageList").append(response);
		}
	});
}


function loadChatWindowForfriend(elem) {
	var friendUserID = $(elem).attr("id");
	
	showChatWindow(elem);
	$.ajax({
		type : 'GET',
		url : 'deleteNotifications',
		data : {
			friendUserID : friendUserID
		},
		success : function(response) {
			updateMessageNotifications()
			window.location.replace("/FriendHub/chat");
		},
		error : function(response) {
			// alert(response);
		}
	});
}

function showChatWindow(elem) {
	var friendUserID = $(elem).attr("id");
	$.ajax({
		type : 'GET',
		url : 'getChatHistoryWithFriend',
		data : {
			friendUserID : friendUserID
		},
		success : function(response) {
			$('#chatWindow').html('');
			$('#chatWindow').append(response)
		},
		error : function(response) {
			// alert(response);
		}
	});
}

var gResponse;
function onSearch() {

	var s = $('#friendNames').val();
	var res = s.substr(1, s.length - 2);
	var result = res.split(",");
	$("#contactSearchBar").autocomplete({
		source : result
	});

}

function loadUserProfileAjax(element) {
	$(element).closest("form").submit();

}

function onClickSearch() {
	var message = $('#contactSearchBar').val();

	$
			.ajax({
				type : 'POST',
				url : 'getFriendList',
				data : {
					text : message
				},

				success : function(response) {

					if (response) {
						$('#contactsBlock').html('')
						$('#contactsBlock')
								.append(
										'<div> <div style="float: left; width: 7%; height: 200px;"> <img id="profilePicture" alt="Profile Picture"src=""></div></div><div style="width: 40%; height: 200px; float: left;"><a href="getSearchedFriend">'
												+ response
												+ '</a><br> <label style="color: #A9A9A9"> friends</label></div>');
					}
				}
			});

}

function onGlobalPeopleSearch() {

	$.ajax({
		type : 'POST',
		url : 'getAllUserList',
		dataType : 'json',
		data : {
			text : "h"
		},

		success : function(response) {

			$("#globalSearchBar").autocomplete({
				source : response
			});

		}
	});

}

function onClickGlobalPeopleSearch() {
	var message = $('#globalSearchBar').val();

	$
			.ajax({
				type : 'POST',
				url : 'getFriendList',
				data : {
					text : message
				},

				success : function(response) {

					if (response) {
						$('#contactsBlock')
								.html(
										'<div> <div style="float: left; width: 7%; height: 200px;"> <img id="profilePicture" alt="Profile Picture"src=""></div></div><div style="width: 40%; height: 200px; float: left;"><a href="getSearchedUser">'
												+ response + '</a><br></div>');
					}
				}

			});

}
