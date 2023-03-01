import { Button, Grid } from "@mui/material";
import { Box } from "@mui/system";
import { DataGrid, GridColDef } from "@mui/x-data-grid";
import * as React from "react";
import common from "../state/common";

interface IPublicProps {}

const rows = [
  { id: 1, number: 1, title: "test", date: "2022-12-12" },
  { id: 2, number: 2, title: "test", date: "2022-12-12" },
  { id: 3, number: 3, title: "test", date: "2022-12-12" },
];

const columns: GridColDef[] = [
  { field: "number", headerName: "num" },
  { field: "title", headerName: "title" },
  { field: "createDateTime", headerName: "createdAt" },
  { field: "lastModifiedDate", headerName: "updatedAt" },
];

interface IPublic {
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
  console.log(data);
  return (
    <>
      <Box sx={{ height: 400, width: "100%" }}>
        <DataGrid
          columns={columns}
          rows={data || []}
          rowsPerPageOptions={[5]}
        />
      </Box>
      <Button
        sx={{ marginTop: 2, marginLeft: "74vw", backgroundColor: "#1982b3" }}
        variant="contained"
      >
        등록
      </Button>
    </>
  );
};

export default Public;
