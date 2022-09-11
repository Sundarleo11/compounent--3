import React,{Component} from 'react';
import axios from 'axios';
import {BiDislike} from "react-icons/bi";

class DisLike extends Component{

    constructor(props){
        super(props);
    }

    disLikeHandler = ((event) => {
        axios
          /*.put(
            `http://localhost:8080/api/v1.0/tweets/${this.props.email}/dislike/${this.props.id}`
          )*/
          //.put(`https://lnnp2qppv5.execute-api.us-east-1.amazonaws.com/tweetapp/api/v1.0/tweets/${this.props.email}/dislike/${this.props.id}`)
          .put(`https://cwrhgh04je.execute-api.us-east-1.amazonaws.com/dislike-v1/api/v1.0/tweets/${this.props.email}/dislike/${this.props.id}`)
          .then((res) => {
            console.log(res.data);
          })
          .catch((err) => {
            console.log("error" + err);
          });
          event.preventDefault();
      });

    render(){
        return(
          <div>
              <button
                    className="btn btn-primary"
                    onClick={this.disLikeHandler}
                  >
                    <BiDislike />
                  </button>
                  <span> {this.props.dislike}</span>
          </div>
        )
    }
}

export default DisLike;