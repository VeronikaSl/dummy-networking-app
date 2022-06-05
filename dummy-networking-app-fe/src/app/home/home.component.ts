import { Component, OnInit } from '@angular/core';
import { Post } from '../model/post.model';
import { PostService } from '../service/post.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  showCommentsArray = [] as ShowComments[];
  posts = [] as Post[];
  postsToBeShown = [] as Post[];
  newComment = "";

  constructor(private postService: PostService) {
    postService.getPosts().subscribe(data => {
      this.posts = data.filter(p => p.refPostId === null || p.refPostId === undefined);
      this.posts.forEach(p => this.showCommentsArray.push({ id: p.id, showComments: false, comments: [] as Post[] }));
    }
    );
  }

  ngOnInit(): void {
  }

  showComments(id: string) {
    const index = this.showCommentsArray.findIndex(sc => sc.id === id);
    this.showCommentsArray[index].showComments = !this.showCommentsArray[index].showComments;
    this.postService.getComments(id).subscribe(data => {
      const postIndex = this.posts.findIndex(pi => pi.id = id);
      this.posts[postIndex].answers = data;
    }
    );
  }

  saveComment(postRefId: string, user: string) {
      this.postService.saveComment({message: this.newComment, user: user, refPostId: postRefId});
  }


  shouldCommentsBeShown(id: string): boolean {
    const index = this.showCommentsArray.findIndex(sc => sc.id === id);
    return this.showCommentsArray[index].showComments;
  }

}

interface ShowComments {
  id: string;
  showComments: boolean
  comments: Post[]
}
