import { Box, Button, Grid, Group, TextInput } from '@mantine/core';
import { paths } from '@/routes';
import { useForm, zodResolver } from '@mantine/form';
import { notifications } from '@mantine/notifications';
import { CategoriaCreateDto as CategoriaCreateSchema } from '@/api/dtos';
import { useCreateCategoria } from '@/hooks';
import { NavLink, useNavigate } from 'react-router-dom';

export default function CategoriaCreateForm() {
  const navigate = useNavigate();
  const form = useForm({
    validate: zodResolver(CategoriaCreateSchema),
    initialValues: { denominacion: "" },
  });

  const createCategoria = useCreateCategoria();

  const handleSubmit = form.onSubmit((values) => {
    createCategoria.mutate(
      { variables: values },
      {
        onSuccess: () => {
          notifications.show({
            title: "Éxito",
            message: "Categoria creada correctamente",
          });
          navigate(paths.dashboard.management.categorias.list);
        },
        onError: (error) => {
          notifications.show({
            title: "Error",
            message:
              error instanceof Error
                ? error.message
                : "Ocurrió un error inesperado",
            color: "red",
          });
        },
      }
    );
  });

  return (
    <Box component="form" onSubmit={handleSubmit} maw={400}>
      <TextInput
        label="Nombre"
        placeholder="Ingrese el nombre"
        {...form.getInputProps("denominacion")}
      />

      <Group justify="flex-end" mt="md">
        <Button variant='outline' component={NavLink} to={paths.dashboard.management.categorias.list}>
          Cancelar
        </Button>
        <Button type="submit" loading={createCategoria.isPending}>
          Crear
        </Button>
      </Group>
    </Box>
  );
}
