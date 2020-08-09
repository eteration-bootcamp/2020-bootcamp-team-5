import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter as Router, Route } from "react-router-dom";
import { createStore } from 'redux';
import reducer from './reducers';
import { Provider } from 'react-redux';
import 'bootstrap/dist/css/bootstrap.min.css';

import WelcomePage from './containers/WelcomePage';

import Home from './components/Home';
import Profile from './components/Profile';

const store = createStore(
  reducer,
  window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__()
);

const App = () => {
  return (
      /*<div className="row">
      <div className="container-fluid center-content">*/
        <Router>
          <Route path="/" exact component={WelcomePage} />
          <Route path="/profile" exact component={Profile} />
        </Router>
       /*</div>
      </div>*/
  );
};


export default App;

const wrapper = document.getElementById("app");
wrapper ? ReactDOM.render(<Provider store={store}><App /></Provider>, wrapper) : false;