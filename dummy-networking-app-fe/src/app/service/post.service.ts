import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Post, SavePost } from '../model/post.model';

@Injectable({
  providedIn: 'root',
})
export class PostService {

 private headers= new HttpHeaders()
  .set('content-type', 'application/json')
  .set('Access-Control-Allow-Origin', '*');

  constructor(private http: HttpClient) { }

  getPosts(): Observable<Post[]> {
    return this.http.get<Post[]>('http://localhost:8080/posts', {headers: this.headers});
  }

  getComments(postId: string): Observable<Post[]> {
    return this.http.get<Post[]>(`http://localhost:8080/posts/${postId}/answers`, {headers: this.headers});
  }

  saveComment(post: SavePost) {
      this.http.post('http://localhost:8080/posts', post,  {headers: this.headers}).subscribe();
  }

}