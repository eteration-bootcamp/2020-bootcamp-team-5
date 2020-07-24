import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter as Router, Route } from "react-router-dom";

import Login from './components/Login';
import Navigation from './components/Navigation';

const App = () => {
  return (
    <div className="row">
      <div className="container-fluid center-content">
        <Router>
          <Navigation />
          <Route path="/" exact component={Login} />
          <Route path="/login" exact component={Login} />
        </Router>
      </div>
    </div>
  );
};


export default App;

const wrapper = document.getElementById("app");
wrapper ? ReactDOM.render(<App />, wrapper) : false;