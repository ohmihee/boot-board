import { Button, Grid } from "@mui/material";
import { Box } from "@mui/system";
import { DataGrid, GridColDef, GridEventListener } from "@mui/x-data-grid";
import * as React from "react";
import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import common from "../state/common";

interface IPublicProps {}

const rows = [
  { id: 1, number: 1, title: "test", date: "2022-12-12" },
  { id: 2, number: 2, title: "test", date: "2022-12-12" },
  { id: 3, number: 3, title: "test", date: "2022-12-12" },
];

const columns: GridColDef[] = [
  ///{ field: "id", headerName: "id", hideable: true },
  { field: "title", headerName: "title" },
  { field: "createDateTime", headerName: "createdAt" },
  { field: "lastModifiedDate", headerName: "updatedAt" },
];

interface IPublic {
  id: string;
  category: string;
  contents: [
    {
      order: number;
      contentType: string;
      content: string;
    }
  ];
  title: string;
  writer: string;
  openStatus: string;
}

const Public: React.FunctionComponent<IPublicProps> = (props) => {
  const { data } = common();
  const [boardId, setBoardId] = useState<string>("");
  const navigate = useNavigate();

  const handleRowClick: GridEventListener<"rowClick"> = (params) => {
    navigate(`/public/form/${params.id}`);
  };
  return (
    <>
      <Box sx={{ height: 400, width: "100%" }}>
        <DataGrid
          columns={columns}
          rows={data || []}
          rowsPerPageOptions={[5]}
          checkboxSelection
          onRowClick={handleRowClick}
        />
      </Box>
      {/* {data?.map((value: any, index: number) => (
        <div>{}</div>
      ))} */}
      <Link to="/public/form">
        <Button
          sx={{ marginTop: 2, marginLeft: "74vw", backgroundColor: "#1982b3" }}
          variant="contained"
        >
          등록
        </Button>
      </Link>
    </>
  );
};

export default Public;
