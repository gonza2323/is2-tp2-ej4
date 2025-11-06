import { Alert, Button, Card, Group, Loader, Stack, Text } from "@mantine/core"
import { paths } from "@/routes"
import { NavLink } from "react-router-dom"
import { useGetCategoria } from "@/hooks"

export default function CategoriaDetalle({ categoriaId }) {
  const { data: categoria, isLoading, error } = useGetCategoria({
    route: { id: categoriaId }
  })

  if (isLoading) return <Loader />
  if (error)
    return (
      <Alert color="red" maw={400}>
        Error al cargar categoria
      </Alert>
    )

  return (
    <Card shadow="sm" padding="lg" maw={500}>
      <Stack gap="sm">
        <Group>
          <Text color="dimmed">Nombre:</Text>
          <Text>{categoria?.denominacion || "-"}</Text>
        </Group>
      </Stack>

      <Group justify="flex-end" mt="md">
        <Button
          variant="outline"
          component={NavLink}
          to={paths.dashboard.management.categorias.list}
        >
          Volver
        </Button>
      </Group>
    </Card>
  )
}
