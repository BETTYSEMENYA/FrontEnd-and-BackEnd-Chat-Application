import { Component } from '@angular/core';
import { ChatService, Message } from './chat.service'; 

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private chatService: ChatService) {
    chatService.messages.subscribe((msg: Message) => {
      console.log("Response From WebSocket Server:", msg);
    });
  }

  private message: Message = {
    author: 'elliot forbes',
    message: 'howdy folks'
  };

  sendMsg() {
    console.log("New Message sent from client ");
    this.chatService.messages.next(this.message);
  console.log(this.message)  }
}
