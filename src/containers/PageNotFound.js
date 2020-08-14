import React from 'react';
import {Container, Row, Col, Image, Button} from 'react-bootstrap';
import { useHistory } from "react-router-dom";
import pageNotFoundImage from '../img/404.png';
import pageNotFoundText from '../img/404-text.png';
import '../styles/Main.css';

function PageNotFound() {

  const history = useHistory();

  const routeChange = () =>{ 
    let path = '/'; 
    history.push(path);
  }

  return (
    <Container className="not-found-container" fluid>
        <Row>
          <Col md={3} lg={2} xl={1} className="d-none d-md-block"></Col>

          <Col xs={12} sm={12} md={6} lg={8} xl={10} className="not-found-col ver-hor-center">
            <Row>
              <Image src={pageNotFoundImage} fluid/>
            </Row>

            <Row>
              <Image src={pageNotFoundText} fluid/>
            </Row>

            <Row>
              <Button onClick={routeChange}className="not-found-button" variant="warning" size="lg">
                  BACK TO HOME
              </Button>
            </Row>
          </Col>

          <Col md={3} lg={2} xl={1} className="d-none d-lg-block"></Col>
        </Row>
    </Container>
  );

}

export default PageNotFound;
