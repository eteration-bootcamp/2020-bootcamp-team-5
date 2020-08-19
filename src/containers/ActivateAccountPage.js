import React, { useState, useEffect } from 'react';
import {Container, Row, Col, Form, Button} from 'react-bootstrap';
import '../styles/Main.css';
import logo from '../img/noteration-logo-dark.png';
import axios from 'axios';
import {ACTIVATE_ACCOUNT_API} from '../config/api';
import { useHistory } from 'react-router';

function ActivateAccountPage(props) {
  const [activatingResult, setActivatingResult] = useState(false);
  const [errorMessage, setErrorMessage] = useState('');

  const history = useHistory();

  useEffect(() => {
    axios.post(`${ACTIVATE_ACCOUNT_API}${props.match.params.id}`)
    .then(res => {
        setErrorMessage("");
        setActivatingResult(true);
    })
    .catch(error => {
        setActivatingResult(false);
        setErrorMessage("Invalid activation code! Check your activation code and try again!");
    });
  }, []);

  function routeChange() {
    history.push('/');
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

              <Row className="justify-content-center">
                  <h2>Account Activation</h2>
              </Row>


            {
                activatingResult ?
                
                (
                    <>
                        <Row>Your account has been activated successfuly!</Row>
                        <Row className="justify-content-center"><Button variant="link" className="forgot-password-text go-back-button" onClick={() => routeChange()}>← Go Back</Button></Row>
                    </>
                ) :
                (
                    <>
                        <Row>{errorMessage}</Row>
                        <Row className="justify-content-center"><Button variant="link" className="forgot-password-text go-back-button" onClick={() => routeChange()}>← Go Back</Button></Row>
                    </>
                )

            }

            </div>
          </Col>
          <Col md={2} className="d-none d-md-block"></Col>
        </Row>
    </Container>
  );
}

export default ActivateAccountPage;
