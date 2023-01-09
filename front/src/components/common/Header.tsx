import { Box, Grid } from '@mui/material';
import * as React from 'react';

interface IHeaderProps {
}

const Header: React.FunctionComponent<IHeaderProps> = (props) => {
  return (
    <Grid className='header'>
        <Box
            component='img'
            src="header.png"
            width='5vw'
        />
    </Grid> 
  );
};

export default Header;
