import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title: any = 'Demo';
  greeting: any = {};
  constructor(private http: HttpClient) {
    http.get('resource').subscribe(data => this.greeting = data);
  }
}

