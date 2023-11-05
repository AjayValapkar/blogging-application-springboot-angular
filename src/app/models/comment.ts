import { Post } from "./post"
import { User } from "./user"

export class Comment {
    content!:string
    author!:User
    blog!:Post
    
}
