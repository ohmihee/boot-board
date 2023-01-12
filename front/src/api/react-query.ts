// export const queryClient = new ({
//     defaultOptions: {
//       queries: {
//         retry: 0,
//         useErrorBoundary: true,
//         staleTime: Infinity,
//         // cacheTime: Infinity,
//       },
//       mutations: {
//         useErrorBoundary: true,
//       },
//     },
//   })

import { QueryClient } from 'react-query';

export const queryClient = new QueryClient();