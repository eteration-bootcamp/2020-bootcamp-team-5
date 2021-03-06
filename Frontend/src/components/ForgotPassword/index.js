import React, { useState } from 'react';
import {Form, Button} from 'react-bootstrap';
import {useDispatch} from 'react-redux';
import '../../styles/Main.css';
import axios from 'axios';
import {FORGOT_PASSWORD_API} from '../../config/api';

function ForgotPassword() {
    const dispatch = useDispatch();
    const [authResult, setAuthResult] = useState(false);
    const [email, setEmail] = useState('');
    const [errorMessage, setErrorMessage] = useState('');

    function grabEmail(e) {
        setEmail(e.target.value);
    }

    function forgotPassword(e) {
        e.preventDefault();

        axios.post(FORGOT_PASSWORD_API + email)
            .then(res => {
                setErrorMessage("");
                setAuthResult(true);
            })
            .catch(error => {
                setAuthResult(false);
                setErrorMessage("Please check your email and try again!");
            });
    }
    
    return(
        <div>
            <Form onSubmit={forgotPassword} className="form-auth-margin-top">
                <h5>{errorMessage}</h5>
                <h2>Password Reset</h2>
                {authResult ? (<span>Password reset link has been sent to your email.</span>) :
                (<><Form.Group controlId="email">
                    <Form.Control placeholder="Enter your email here" onChange={e => grabEmail(e)} />
                </Form.Group>

                <Button variant="dark" type="submit">
                    Reset
                </Button></>)}
            </Form>

            <Form.Text className="text-muted">
                <Button variant="link" className="forgot-password-text go-back-button" onClick={() => dispatch({ type: 'SWITCH_FORGOT_REGISTER' })}>← Go Back</Button>
            </Form.Text>
        </div>
    );
}

export default ForgotPassword;
