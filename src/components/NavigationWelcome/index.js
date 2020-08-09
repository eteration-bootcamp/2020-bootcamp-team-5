import React from 'react';
import {Row, Col, Navbar} from 'react-bootstrap';
import logo from '../../img/noteration-logo.png';
import LoginForm from '../LoginForm';
import '../../styles/Main.css';

function NavigationWelcome() {
    return(
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

                    <Col xs={12} md={6} lg={5} xl={4}>
                        <LoginForm/>
                    </Col>

                    <Col lg={2} className="d-none d-lg-block"></Col>
                </Row>
            </Navbar>
        </>
    );
}

export default NavigationWelcome;