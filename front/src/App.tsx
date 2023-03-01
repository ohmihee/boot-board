import React, { useEffect, useState } from "react";
import logo from "./logo.svg";
import "./App.css";
import Home from "./pages/Home";
import { queryClient } from "./api";
import { QueryClientProvider } from "react-query";
import { GlobalStyles } from "@mui/styled-engine";
import { styles } from "./styles/GlobalStyles";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import Public from "./pages/Public";
import Notice from "./pages/Notice";
import Faq from "./pages/Faq";
import Qna from "./pages/Qna";
import { Provider } from "jotai";
import PublicForm from "./pages/PublicForm";

function App() {
  // const test = async () => {
  //   removeCommonBoardById("63be76733da10973f48aa8e3");
  // };
  const router = createBrowserRouter([
    {
      element: <Home />,
      children: [
        { path: "/", element: <Public /> },
        {
          path: "/notice",
          element: <Notice />,
        },
        {
          path: "/faq",
          element: <Faq />,
        },
        { path: "/qna", element: <Qna /> },
        { path: "/form", element: <PublicForm /> },
      ],
    },
  ]);

  return (
    <div className="App">
      <Provider>
        <QueryClientProvider client={queryClient}>
          <GlobalStyles styles={styles} />
          {/* <Home /> */}
          <RouterProvider router={router} />
        </QueryClientProvider>
      </Provider>
    </div>
  );
}

export default App;
