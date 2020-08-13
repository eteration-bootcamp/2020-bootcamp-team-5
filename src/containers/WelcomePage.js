import React from 'react';
import {Container, Row, Col} from 'react-bootstrap';
import '../styles/Main.css';
import SignupForm from '../components/SignupForm';
import ForgotPassword from '../components/ForgotPassword';
import NavigationWelcome from '../components/NavigationWelcome';
import {useSelector} from 'react-redux';

function WelcomePage() {
  const showForgotPassword = useSelector(state => state.showForgotPassword);

  return (
    <Container fluid className="d-flex flex-column main-container">
        <Row>
          <Col className="reset-padding">
            <NavigationWelcome/>
          </Col>
        </Row>

        <Row className="flex-grow-1">
          <Col lg={2} className="d-none d-lg-block"></Col>

          <Col xs={12} md={6} lg={4} className="slogan-container">
            <Row className="justify-content-center">
              <h1>Noteration</h1>
            </Row>
            <Row>{<br/>}</Row>
            <Row className="justify-content-center text-center">
              <h2>Your digital notebook!</h2>
            </Row>
          </Col>

          <Col xs={12} md={6} lg={4} className="auth-container-out text-center">
            <div className="auth-container">
              { 
                showForgotPassword ? <ForgotPassword/> : <SignupForm />
              }
            </div>
          </Col>

          <Col lg={2} className="d-none d-lg-block"></Col>
        </Row>
    </Container>
  );

}

export default WelcomePage;
