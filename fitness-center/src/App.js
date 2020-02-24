import React, {Component} from 'react';
import './App.css';
import BaseComponent from './Components/BaseComponent.jsx';
import {BrowserRouter as Router, Route, Switch, withRouter} from 'react-router-dom';
import SignupConfirmation from './Components/SignupComfirmationComponent';

class App extends Component {
  
    constructor(){
      super()

      this.state = {
        
              firstName: "",
              lastName: "",
              location: "",
              phone: ""
            }
     
      this.signupInfo = this.signupInfo.bind(this)
    }

    signupInfo(firstName, lastName, location, phone){
        this.setState(
          {
            firstName: firstName,
            lastName: lastName,
            location: location,
            phone: phone
          }
        )
    }

      render(){
      return (
        <div className="app-base">
            <div className="inner-div">
                <div className="row">
                  <div className="col-md-8" style={{paddingLeft: "4%"}}>
                      <h1 style={{fontFamily: "Times"}}>Xtreme Fitness</h1>
                      <h5 style={{fontFamily: "monospace", fontWeight: "550"}}>
                        Looking to get results? Add some fitness to your workout!</h5>
                  </div>
                  <div className="col-md-4 banner-style">
                      <h6>404.555.4321</h6>
                  </div>
                </div>  
              <div className=" nav-style">
                    <nav className="navbar navbar-expand-lg navbar-light bg-light">
                    <a className="navbar-brand" href="/" style={{width: "4%", color: "rgb(109, 18, 18)"}}><img src="./xtreme.jpg" 
                    style={{borderRadius: "50%",height: "100%", width: "100%", marginLeft: "0%"}}></img></a>
                      
                        <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                          <span className="navbar-toggler-icon"></span>
                        </button>
                        <div className="collapse navbar-collapse" id="navbarText" >
                          <ul className="navbar-nav mr-auto" >
                            <li className="nav-item active">
                              <a className="nav-link" href="#">About us </a>
                            </li>
                            <li className="nav-item">
                              <a className="nav-link" href="#">Contact us</a>
                            </li>
                          </ul>
                          <ul className="navbar-nav mr-ml">
                              <li className="nav-item">
                                  <a className="nav-link" href="#">Sign in</a>
                                </li>
                                <li className="nav-item">
                                  <a className="nav-link" href="#">Sign out</a>
                                </li>
                          </ul>
                        </div>
                    </nav>
              </div> 
              <Router>
                <Switch>
                    <Route path="/" exact component={BaseComponent}/>
                    <Route path="/signup" component={SignupConfirmation}></Route>
                    <Route path="" component={ErrorComponent}></Route> 
                </Switch>
              </Router>
                {/* <BaseComponent signupInfo={this.signupInfo} firstName={this.state.firstName}></BaseComponent> */}
            </div>
              <div className="row" style={{width: "100%", paddingLeft: "16%"}}>
                <div className="col-md-4" style={{textAlign: "left"}}>
                    <p><small>Copyright &copy; Xtreme fitness</small></p>
                    <p><small>555.555.5555</small></p>
                </div>
                
                  <div className="col-md-4 socilmedia-style" >
                        <span>
                          <a href="#"><img className="socilmedia-img-style" src="facebook-logo.jpg" alt="facebook-link"/></a>
                        </span>
                        <span>
                          <a href="#"><img className="socilmedia-img-style" src="twitter-logo.jpg" alt="twitter-link"/></a>
                        </span>
                        <span>
                          <a href="#"><img className="socilmedia-img-style" src="youtube-logo.jpg" alt="youtube-link"/></a>
                        </span>
                    </div>
                    <div className="col-md-4">
                        
                    </div>
                  </div>
          
        </div>
      );
    }
}

export default App;

function ErrorComponent(){
  return (
      <div>
          <div className="error-container-style">An Error occured. Please contact System Administrator @ 
          <a href="#">xyz@admin.org</a></div>
      </div>
    )
  }