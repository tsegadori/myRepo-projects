 import React, {Component} from 'react'
import '../Header/header.css'
 
class Header extends Component{

    constructor(){
        super();
        this.state={
            showRegion: false,
            showMenu: true
        }            
       
        this.showRegions=this.showRegions.bind(this)
        this.showMenu=this.showMenu.bind(this)
        this.hideMenu=this.hideMenu.bind(this)

    }

    showRegions(){
        return this.setState({ showRegion: !this.state.showRegion})
    }

    showMenu(){
        return this.setState({showMenu: !this.state.showMenu})
    }

    hideMenu(){
        return this.setState({showMenu: !this.state.showMenu})
    }

    render(){
        return(
            
            <div className="container-fluid "> 
            <div className="show">
                    <div className="d-flex justify-content-end">
                                <ul >
                                    <li className="links">
                                        <a href="#">Espanol</a>&nbsp;|&nbsp;
                                    </li>
                                    <li className="links">
                                    <button className="region-links-button" onClick={this.showRegions}>
                                        Choose your region&nbsp;<span id="symbol1">&or;</span></button>&nbsp;|&nbsp;
                                        {this.state.showRegion &&
                                        <ul className="regions-list">
                                            <li className="region-links">
                                            --- <a href="#">English</a> ---
                                            </li>
                                            <li className="region-links">
                                            --- <a href="#">Amharic</a> ---
                                            </li>
                                            <li className="region-links">
                                            --- <a href="#">Espanol</a> ---
                                            </li>
                                            <li className="region-links">
                                            --- <a href="#">Italian</a> ---
                                            </li>
                                        </ul>
                                        } 
                                    </li>
                                    <li className="links">
                                        <a href="#">Security</a>&nbsp;|&nbsp; 
                                    </li>
                                    <li className="links">
                                        <a id="register-link" href="#">Register</a>
                                    </li>
                                </ul>
                    </div>
            </div>
          
             <div className="show">
                <div className="container-fluid" style={{float: 'right', paddingRight: '0px'}}>
                    <div >

                        <form className="form-inline d-flex justify-content-end">
                            <input type="text" placeholder="User name"></input>
                            <input type="password" placeholder="Password"></input>
                            <button className="btn btn-primary btn-lg btn-custom">Sign in</button>
                        </form>   

                        </div>  
                        <div className="d-flex justify-content-end">
                            <span className="user-info"><a href="#">Forgot your user ID&nbsp; </a> or &nbsp; <a  href="#"> password</a>?</span>
                        </div>     
                        <div className="d-flex justify-content-end">
                            <span className="user-info">By signing in, you agree to our website&nbsp; <a href="#">Terms &nbsp;<>&</>&nbsp;Conditions</a>&nbsp; and &nbsp;<a href="#">Privacy Statment.</a></span>
                        </div>                                   
                </div>
            </div>
                   
            <div className="show">
                    <div className="d-flex justify-content-start ">
                        <img className="logo " src="logo.png"></img>
                    </div>
            </div>

               
            <div className="show">
                <div className="container-fluid nav-container ">
                            <div className="row">
                                <div className="col-md-12">
                                    <ul className="navigate d-flex justify-content-start">
                                        <li className="navbar-links">
                                            <a href="#">Why&nbsp;KP</a>
                                        </li>
                                        <li className="navbar-links">
                                            <a href="#">Shop&nbsp;Plans</a>
                                        </li>
                                        <li className="navbar-links">
                                            <a href="#">Doctors&nbsp;&&nbsp;Locations</a>
                                        </li>
                                        <li className="navbar-links">
                                            <a href="#">Health&nbsp;&&nbsp;Wellness</a>
                                        </li>
                                        <li className="navbar-links">
                                            <a href="#">Get&nbsp;care</a>
                                        </li>
                                        <li className="d-flex justify-content-end" id="search1">
                                            <input id="btn1" type="button"></input>
                                        </li>                            
                                    </ul>
                                    <ul>
                                        
                                    </ul>
                                </div>
                                
                            </div>
                        
                            </div>
            </div>

      
               {this.state.showMenu && <div className="toggle-menu">
                        <img className="logo-style" src="mini-logo.png"></img>          
                        <span className="menu-items">
                            <input id="search2" className="menu-input" type="button" onClick={this.showMenu}/>
                            <input id="menu1" className="menu-input" type="button" onClick={this.showMenu}/>

                        </span>
                </div>}

                {!this.state.showMenu && <div className="responsive-menu">
                    <div className="d-flex justify-content-end">
                        <input id="mobile-exit" type="button" onClick={this.hideMenu} value="X"/>
                    </div>
                        <div className="mobile-menu">
                                <div className="mini-lists">
                                        Why KP
                                </div>
                                <div className="mini-lists">
                                        Shop Plans
                                </div>
                                <div className="mini-lists">
                                        Doctors & Locations
                                </div>
                                <div className="mini-lists">
                                        Health & Wellness
                                </div>
                                <div className="mini-lists">
                                        Get Care
                                </div>
                                <div className="mini-lists">
                                        Sign in to access care
                                </div>
                                <div className="mini-lists">
                                        Espanol
                                </div>
                                <div className="mini-lists">
                                        Choose your region
                                </div>
                         </div>      
                        </div>}
                            
                    </div>                    
            
        )
    }
}

export default Header;