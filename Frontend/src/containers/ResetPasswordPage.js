import React, { useState } from 'react';
import {Container, Row, Col, Form, Button} from 'react-bootstrap';
import '../styles/Main.css';
import logo from '../img/noteration-logo-dark.png';
import axios from 'axios';
import {NEW_PASSWORD_API} from '../config/api';
import { useHistory } from 'react-router';

function ResetPasswordPage(props) {
  const [resetResult, setResetResult] = useState(false);
  const [errorMessage, setErrorMessage] = useState('');
  const [password, setPassword] = useState('');

  const history = useHistory();

  function routeChange() {
    history.push('/');
  }

  function grabPassword(e) {
    setPassword(e.target.value);
  }

  function resetPassword(e) {
    e.preventDefault();

    axios.post(`${NEW_PASSWORD_API}${props.match.params.id}`, password, { 'headers': { 'Content-Type': 'text/plain' } })
        .then(res => {
            setErrorMessage("");
            setResetResult(true);
        })
        .catch(error => {
            setResetResult(false);
            setErrorMessage("Invalid reset code page! Check your code and try again!");
        });
  }

  return (
    <Container fluid className="reset-password-container">
        <Row className="">
          <Col md={2} className="d-none d-md-block"></Col>
          <Col xs={12} md={8} className="reset-password-col text-center">
            <div className="reset-password-box">
              <Row className="justify-content-center">
                <img
                src={logo}
                width="200"
                height="100"
                className="d-inline-block align-top"
                alt="Noteration"
                />
              </Row>

              <Form onSubmit={resetPassword}>
                  <h5>{errorMessage}</h5>
                  <h2>Password Reset</h2>
                  {
                    resetResult ? 
                    (
                      <>
                        <Row>Your password has been changed successfuly!</Row>
                        <Row className="justify-content-center"><Button variant="link" className="forgot-password-text go-back-button" onClick={() => routeChange()}>← Go Back</Button></Row>
                      </>
                    ) :
                    (
                      <>
                        <Form.Group controlId="email">
                          <Form.Control type="password" placeholder="Enter your new password" onChange={e => grabPassword(e)} />
                        </Form.Group>

                        <Button variant="dark" type="submit">
                            Reset
                        </Button>
                      </>
                    )
                  }
              </Form>
            </div>
          </Col>
          <Col md={2} className="d-none d-md-block"></Col>
        </Row>
    </Container>
  );
}

export default ResetPasswordPage;
