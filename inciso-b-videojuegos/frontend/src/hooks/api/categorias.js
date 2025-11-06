import { createDeleteMutationHook, createGetQueryHook, createPaginationQueryHook, createPostMutationHook } from '@/api/helpers';
import { notifications } from '@mantine/notifications';
import { z } from 'zod';

const QUERY_KEY = 'categories';
const BASE_ENDPOINT = '/categories';

export const useGetCategoria = createGetQueryHook({
  endpoint: `${BASE_ENDPOINT}/:id`,
  queryKey: QUERY_KEY,
});

export const useGetCategorias = createPaginationQueryHook({
  endpoint: BASE_ENDPOINT,
  queryKey: QUERY_KEY,
});

export const useCreateCategoria = createPostMutationHook({
  endpoint: BASE_ENDPOINT,
});

export const useDeleteCategoria = createDeleteMutationHook({
  endpoint: `${BASE_ENDPOINT}/:id`,
  onSuccess: (data, variables, context, queryClient) => {
    queryClient.invalidateQueries({ queryKey: [QUERY_KEY] });
    notifications.show({
      title: 'Borrado',
      message: 'La categoria fue borrada con éxito',
      color: 'green',
    });
  },
  onError: (error) => {
    notifications.show({
      title: 'Error',
      message: error.message || 'No se pudo borrar la categoria',
      color: 'red',
    });
  },
});
