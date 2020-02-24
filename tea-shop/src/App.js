import React from 'react';
import logo from './logo.svg';
import './App.css';

function App() {
  return (
          <div className="">
            <div className="row top-banner"  >
                <div className="col-md-8" >
                    <div style={{position: "relative", float: ""}}>
                        <img src="tea.jpg" alt="tea" className="tea" ></img>
                    </div>
                    <div className=""  style={{position: "relative", marginLeft: "40%", marginTop: "-10%"}}>
                        <p><h1>Herb's Tea Shop</h1></p>
                        <p style={{fontFamily: "cursive", fontStyle: "italic"}}>We have got what you need, whatever your cup of tea.</p>
                    </div>
                </div>
                
                <div className="col-md-4 d-none d-md-block" style={{paddingTop: "2%"}}>
                  <address>
                    <strong>(123) 456-7890</strong> <br/>
                          1234 U Street NW<br/>
                          Washington DC, 20006
                  </address>
              </div>
            </div>
            
            <nav className="navbar navbar-expand-md bg-dark navbar-dark">

              <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
                  <span className="navbar-toggler-icon"></span>
              </button>

              <div className="collapse navbar-collapse" id="collapsibleNavbar" style={{paddingLeft: "12%"}}>
                  <ul className="navbar-nav" >
                    <li className="nav-item">
                      <a className="nav-link Active" href="#">Home</a>
                    </li>
                    <li className="nav-item">
                      <a className="nav-link" href="#">About Us</a>
                    </li>
                    <li className="nav-item">
                      <a className="nav-link" href="#">Contact Us</a>
                    </li>
                  </ul>
                </div>
              </nav>
            <div className="row ">
              <div className="d-none d-md-block carousel" style={{textAlign: "center", padding: "2%"}}>
              <div id="demo" class="carousel slide" data-ride="carousel" >
                    <ul class="carousel-indicators">
                      <li data-target="#demo" data-slide-to="0" class="active"></li>
                      <li data-target="#demo" data-slide-to="1"></li>
                      <li data-target="#demo" data-slide-to="2"></li>
                    </ul>

                   <div class="carousel-inner" >
                      <div class="carousel-item active">
                        <img src="tea-banner.jpg" alt="Sweat Herbal Tea"/>
                      </div>
                      <div class="carousel-item">
                        <img src="tea-sets.jpg" alt="Black English Tea"/>
                      </div>
                      <div class="carousel-item">
                        <img src="herbal-sets.jpg" alt="Lipton Tea"/>
                      </div>
                   </div>

                  <a class="carousel-control-prev" href="#demo" data-slide="prev">
                      <span class="carousel-control-prev-icon"></span>
                  </a>
                  <a class="carousel-control-next" href="#demo" data-slide="next">
                      <span class="carousel-control-next-icon"></span>
                  </a>

                </div>
              </div>
             </div>
             <div className="container">
                <div className="row">
                    <div className="col-md-4 form-column">
                        <p><h4>Tea of the month club.</h4></p><br></br>
                        <p>Use the form below to sign up <br></br>for our tea of the month club.</p>
                      <form> 
                        <div className="form-group">
                            <label for="nameInput">Name *</label>
                                <input type="text" class="form-control" id="nameInput" />
                            <label for="emailInput">Email address *</label>
                                <input type="email" class="form-control" id="emailInput" />
                            <label for="messageTextarea">Message *</label>
                                <textarea class="form-control" id="messageTextarea" rows="4"></textarea><br></br>
                            <button className="btn btn-success"  type="submit">Send Message</button>
                        </div>
                      </form> 
                      <div style={{marginTop: "27%"}}>
                        <p style={{fontFamily: "cursive"}}>Tea of the Day:</p>
                        <div style={{marginTop: "12%", marginBottom: "6%"}}>
                          <img className="img-thumbnail tea-of-day" src="tea-of-the-day.jpg" alt="Tea of the Day"></img>
                        </div>
                        <div className="text-muted" style={{textAlign: "center", fontWeight: "bold", fontStyle: "italic"}}>
                        <p>Chamomile</p> 
                        <p style={{marginTop: "-6%"}}>Lemongrass Hibiscus</p>
                        </div>
                      </div>
                    </div>
                    <div className="col-md-8 form-column">
                        <p><h4>Our tea is the best!</h4></p><br></br>
                        <p style={{textAlign: "justify"}}>
                          You might say it's destiny that a man named Herb should become so passionate about tea. We think it was just
                          good luck. Our founder, Herb Anderson, travels the world meeting with leading tea mporters and talented tea 
                          growers to keep up the latest in the industry and bring it home to you.
                        </p><br></br>
                        <div className="row">
                            <div className="col-md-4">
                                <p><h5>Tea Sets</h5></p>
                                <div>
                                <img className="tea-details" src="tea-sets.jpg" alt="Tea Sets"></img>
                                <br></br>
                                <p className="tea-cust">Our store stocks a variety of factory made as well as hand made tea sets. We have many styles, 
                                  so come in and choose one that is right for you - or pick the perfect gift.</p>
                                </div>
                            </div>
                            <div className="col-md-4">
                                <p><h5>Tea Varieties</h5></p> 
                                <div>
                                <img className="tea-details" src="herbal-sets.jpg" alt="Tea Varieties"></img>
                                <br></br>
                                <p className="tea-cust">Whether you want to come have a cup in the morning or take a pound home with you, we've got 
                                  you covered with a plethora of delicious tea Varieties.
                                </p>
                                </div>
                            </div>
                            <div className="col-md-4">
                                <p><h5>Tea Tasting</h5></p> 
                                <div>
                                <img className="tea-details" src="tea-banner.jpg" alt="Tea Tasting"></img>
                                <br></br>
                                <p className="tea-cust">Sign up for our weekly tea tasting event. View photos of previous events and hear what real 
                                  customers had to say about their experience.
                                </p>
                                </div>
                            </div>
                        </div>
                        <div className="row">
                          <div className="col-md-4 add-padding" >
                              
                              <address>
                              <p style={{marginBottom: "2rem"}}>
                                <strong >Our Address</strong><br></br>
                              </p>
                              <span >
                                1234 U Street NW<br/>
                                Washington DC, 20006<br></br>
                              </span>
                              <p style={{marginTop: "2rem", marginBottom: "2rem"}}>
                                <strong >Contact</strong><br></br></p>
                                (301) 554 - 4523
                              </address>
                          </div>
                          <div className="col-md-8" style={{padding: "0%"}}>
                              <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d99349.60246736914!2d-77.06750604179688!3d38.90854499999999!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x89b7b81094b566b1%3A0x8fcd1cb86c715be7!2sTeaism%20Union%20Market!5e0!3m2!1sen!2sus!4v1581811658139!5m2!1sen!2sus" 
                              style={{width: "100%", height: "100%", frameborder: "0",border: "0", allowfullscreen: ""}}></iframe>
                           </div>
                        </div>
                    </div>
                </div>
             </div>
             <nav className="navbar navbar-light footer" >
             <div className="social-media text-muted" >
                      <div ><p><small>Follow us for deals: 
                        <a  href="#"><img className="social-media-links" style={{marginLeft: "1%"}} src="facebook_logos.jpg" alt="facebook"></img></a>
                        <a href="#"><img className="social-media-links" src="TwitterBird.jpg" alt="twitter"></img></a>
                        <a href="#"><img className="social-media-links" src="Instagram.jpg" alt="Instagram"></img></a>
                        </small></p>
                      </div>
               <img className="footer-line" src="bottom-line.jpg" alt="Bottom line"></img>
                    <div className="social-media text-muted" >
                      <div ><p><small>Copyright &copy; Herb's Tea Shop</small></p></div>
                      <div style={{marginTop: "-1%"}}><p><small>1234 U St. NW, Washington DC 20006</small></p></div>
                    </div>
              </div>
           </nav>

        </div>
  );
}

export default App;
 
 