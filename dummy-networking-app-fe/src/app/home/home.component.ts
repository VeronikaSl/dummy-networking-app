import { Component, OnInit } from '@angular/core';
import { Post } from '../model/post.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  showCommentsArray = [] as ShowComments[];
  posts = [] as Post[];

  constructor() { 
    const post1 = {id: '1', text: 'Post 1 text', author: 'Duck 1'} as Post
    const post2 = {id: '2', text: 'Post 2 text', author: 'Duck 2'} as Post
    const post3 = {id: '3', text: 'Post 3 text', author: 'Duck 3'} as Post
    this.posts.push(post1);
    this.posts.push(post2);
    this.posts.push(post3);
    this.posts.forEach(p => this.showCommentsArray.push({id: p.id, showComments: false }));
  }

  ngOnInit(): void {
  }

  showComments(id: string) {
    const index = this.showCommentsArray.findIndex(sc => sc.id === id);
    this.showCommentsArray[index].showComments = !this.showCommentsArray[index].showComments;
  }


  shouldCommentsBeShown(id: string): boolean {
    const index = this.showCommentsArray.findIndex(sc => sc.id === id);
    return this.showCommentsArray[index].showComments;
  }

}

interface ShowComments {
  id: string;
  showComments: boolean
}
