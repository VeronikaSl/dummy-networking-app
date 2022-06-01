export interface Post {
    id: string;
    message: string;
    user: string;
    likes ?: number;
    refPostId: string;
    answers: Post[]
}

export interface SavePost {
    message: string;
    user: string;
    refPostId: string;
}