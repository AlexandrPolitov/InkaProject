var userName = 'Alex';
var dialogues_list = new Array();
// карта для сообщений
var map = new Map();

window.onload = function () {

  sendBtn.addEventListener('click',  function (event) {
    if (textField.value != '') {
      addMessage(userName, textField.value);
      textField.value = '';
    }
  });

  textField.addEventListener('keydown', function (event) {
    if (textField.value != '' && event.keyCode == 13) {
      addMessage(userName, textField.value);
      textField.value = '';
    }
  });

  for (let i = 0; i < 29; i++) {
    addDialogue(Math.random());
  }

}

function addDialogue(name) {
  let dialogueName = document.createElement('span');
  dialogueName.className = 'dialogue-name';
  dialogueName.innerText = name;
  let div = document.createElement('div');
  div.className = 'dialogue';
  div.append(dialogueName);
  dialogues.append(div);
  div.addEventListener('click', function (event) {
     div.className = 'active-dialogue';
     dialogues_list.forEach(element => {
       if (element != div) element.className = 'dialogue'; 
     });
  });
  dialogues_list.push(div);
}

function addMessage(name, text) {
  let msg = document.createElement('li');
  let div =  document.createElement('div');
  msg.className = 'message';
  if (name == userName) div.className = 'me';
  else div.className = 'another';
  div.innerHTML = '<span>' + name + ' | ' + text + '</span>';
  msg.append(div);
  messages.append(msg);
  messagesArea.scrollTop = messagesArea.scrollHeight;
}