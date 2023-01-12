import React, {useEffect, useState} from 'react';
import logo from './logo.svg';
import './App.css';
import Home from './components/pages/Home';
import { getCommonBoard } from './api';

function App() {

  const test = async() => {
    const result = await getCommonBoard(null);
    console.log(result,"result====")
  }

  useEffect(()=>{
    test()
  })
  return (
    
    <div className="App">
      <Home/>
      test
    </div>
  );
}

export default App;
