import React, {useState} from 'react';
import {Row, Col, Navbar, Button} from 'react-bootstrap';
import logo from '../../img/noteration-logo.png';
import '../../styles/Main.css';
import {LOGOUT_API} from '../../config/api';
import axios from 'axios';
import { Redirect } from "react-router-dom";

const Navigation = () => {
  const [logoutResult, setLogoutResult] = useState(false);

  function logout(e) {
    e.preventDefault();

    axios.post(LOGOUT_API + localStorage.getItem("auth"))
      .then(res => {
        localStorage.removeItem("auth");
        setLogoutResult(true);
      })
      .catch(error => {
        localStorage.removeItem("auth");
        setLogoutResult(true);
      });
  }

  return (
    logoutResult ? <Redirect to ="/" /> :
    <>
      <Navbar className="navigation-container" expand="lg">
        <Row className="full-width">
            <Col lg={2} className="d-none d-lg-block"></Col>

            <Col xs={12} md={6} lg={3} xl={4} className="logo-responsive">
                <Navbar.Brand href="/">
                  <img
                      src={logo}
                      width="200"
                      height="100"
                      className="d-inline-block align-top"
                      alt="Noteration"
                  />
                </Navbar.Brand>
            </Col>

            <Col xs={12} md={6} lg={5} xl={4} className="navigation-user-info">      
              Welcome Metin Doğan Çelik,
              <Button variant="link" className="logout-text" onClick={logout}>Logout</Button>
            </Col>

            <Col lg={2} className="d-none d-lg-block"></Col>
        </Row>
      </Navbar>
    </>
  )
};

export default Navigation;
