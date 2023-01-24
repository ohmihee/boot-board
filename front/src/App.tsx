import React, {useEffect, useState} from 'react';
import logo from './logo.svg';
import './App.css';
import Home from './components/pages/Home';
import { findCommonBoardAll, removeCommonBoardById } from './api';

function App() {

  const test = async() => {
    removeCommonBoardById("63be76733da10973f48aa8e3");
  }

  useEffect(()=>{
    test()
  })
  return (
    
    <div className="App">
      <Home/>
    </div>
  );
}

export default App;
