import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { map } from 'rxjs/operators';
import { WebSocketService } from './web-socket.service';
import { environment } from 'src/environments/environment';


export interface Message {
  author: string;
  message: string;
}

@Injectable({
  providedIn: 'root'
})
export class ChatService {
  public messages: Subject<Message>;

  constructor(private wsService: WebSocketService) {
    this.messages = <Subject<Message>>wsService
      .connect(environment.CHAT_URL)
      .pipe(
        map((response: MessageEvent): Message => {
        let data = JSON.parse(response.data);
        return {
          author: data.author,
          message: data.message
        };
      })
      ) as  Subject<Message>;
  }
}
