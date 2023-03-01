export const URL = "http://localhost:8080";

export const api = (method: string, headers: {}, path: string, data: any) =>
  fetch(`${URL}/${path}`, {
    method: method,
    headers: headers,
    body: data,
    mode: "cors",
  });

export const getApi = (path: string) =>
  api("GET", { "Content-Type": "application/json" }, path, null)
    .then((res) => res.json())
    .catch((err) => Promise.reject(err));

export const postApi = (path: string, data: any) =>
  api(
    "POST",
    { "Content-Type": "application/json" },
    path,
    JSON.stringify(data)
  );

export const deleteApi = (path: string) => api("DELETE", {}, path, null);
