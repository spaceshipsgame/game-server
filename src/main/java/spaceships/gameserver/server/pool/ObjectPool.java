package spaceships.gameserver.server.pool;

public interface ObjectPool<T> {

    public T getFreeObject();
}
