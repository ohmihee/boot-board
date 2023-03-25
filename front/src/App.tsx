import React, { useEffect, useState } from "react";
import logo from "./logo.svg";
import "./App.css";
import Home from "./pages/Home";
import { queryClient } from "./api";
import { QueryClientProvider } from "react-query";
import { GlobalStyles } from "@mui/styled-engine";
import { styles } from "./styles/GlobalStyles";
import { createBrowserRouter, Outlet, RouterProvider } from "react-router-dom";
import Public from "./pages/Public";
import Notice from "./pages/Notice";
import Faq from "./pages/Faq";
import Qna from "./pages/Qna";
import { Provider } from "jotai";
import PublicForm from "./pages/PublicForm";
import { Container, Grid } from "@mui/material";
import Header from "./components/common/Header";
import CreateNotice from "./pages/CreateNotice";
import CreateFaq from "./pages/CreateFaq";

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
        {
          path: "/faq/form",
          element: <CreateFaq />,
        },
        { path: "/qna", element: <Qna /> },
        { path: "/public/form/:id", element: <PublicForm /> },
        { path: "/public/form", element: <PublicForm /> },
        { path: "/notice/form", element: <CreateNotice /> },
      ],
    },
  ]);

  return (
    <div className="App">
      <Provider>
        <QueryClientProvider client={queryClient}>
          <GlobalStyles styles={styles} />
          <RouterProvider router={router} />
        </QueryClientProvider>
      </Provider>
    </div>
  );
}

export default App;
